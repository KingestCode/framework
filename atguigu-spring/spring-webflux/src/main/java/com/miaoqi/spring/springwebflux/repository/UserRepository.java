package com.miaoqi.spring.springwebflux.repository;

import com.miaoqi.spring.springwebflux.domain.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    /**
     * 根据年龄查找用户
     *
     * @author miaoqi
     * @date 2019-03-13
     * @param start
     * @param end
     * @return
     */
    Flux<User> findByAgeBetween(int start, int end);

    @Query("{'age':{'$gte':30, '$lte': 35}}")
    Flux<User> oldUser();

}
