package com.miaoqi.spring.springwebflux.controller;

import com.miaoqi.spring.springwebflux.domain.User;
import com.miaoqi.spring.springwebflux.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // http://localhost:8080/user/
    /**
     * 以数组形式一次返回数据(传统)
     *
     * @author miaoqi
     * @date 2019-03-12
     * @param
     * @return
     */
    @GetMapping
    public Flux<User> getAll() {
        return this.userRepository.findAll();
    }

    // http://localhost:8080/user/stream/all/
    /**
     * 以流的形式多次返回数据(sse)
     *
     * @author miaoqi
     * @date 2019-03-12
     * @param
     * @return
     */
    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamGetAll() {
        return this.userRepository.findAll();
    }

    /**
     * curl -X POST -d '{"name": "user1", "age": 30}' -H 'Content-Type: application/json' http://localhost:8080/user
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param user
     * @return
     */
    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        // spring data jpa里面, 新增和修改都是save方法, 有id是修改, 没id是新增
        // 根据实际情况置空id
        user.setId(null);
        return this.userRepository.save(user);
    }

    /**
     * 根据id删除用户, 存在返回200, 不存在返回404
     * curl -X DELETE http://localhost:8080/user/5c886c73f877e57cd71974cf
     * 5c886c73f877e57cd71974cf
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
        // deleteById不能判断数据是否存在
        // this.userRepository.deleteById(id);
        return this.userRepository.findById(id)
                // 当你要操作数据, 并返回一个Mono, 这个时候使用flatMap
                // 如果不操作数据, 只是转换数据, 使用map
                .flatMap(u -> this.userRepository.delete(u)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /**
     * 修改数据
     * 存在的时候返回200和修改后的数据
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return this.userRepository.findById(id)
                // flatMap操作数据
                .flatMap(u -> {
                    u.setAge(user.getAge());
                    u.setName(user.getName());
                    return this.userRepository.save(u);
                })
                // map转换数据
                .map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /**
     * 根据id查找用户
     * 存在返回用户信息, 不存在返回404
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> findUserById(@PathVariable("id") String id) {
        return this.userRepository.findById(id)
        .map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /**
     * 根据年龄区间查询用户, 以数组形式返回
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/age/{start}/{end}")
    public Flux<User> findByAge(@PathVariable("start") int start, @PathVariable("end") int end) {
        return this.userRepository.findByAgeBetween(start, end);
    }

    /**
     * 根据年龄区间查询用户, 以流形式返回
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param start
     * @param end
     * @return
     */
    @GetMapping(value = "/stream/age/{start}/{end}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamFindByAge(@PathVariable("start") int start, @PathVariable("end") int end) {
        return this.userRepository.findByAgeBetween(start, end);
    }

    /**
     * 以mongodb语法查询
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param
     * @return
     */
    @GetMapping("/old")
    public Flux<User> oldUser() {
        return this.userRepository.oldUser();
    }

    @GetMapping(value = "/stream/old", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamOldUser() {
        return this.userRepository.oldUser();
    }

}
