package com.miaoqi.spring.springwebflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/1")
    public String get1() {
        log.info("get1 start");
        String result = createStr();
        log.info("get1 end");
        return result;
    }

    @GetMapping("/2")
    public Mono<String> get2() {
        log.info("get2 start");
        Mono<String> result = Mono.fromSupplier(this::createStr);
        log.info("get2 end");
        return result;
    }

    /**
     * Flux返回0-n个数据, 以流的形式返回
     *
     * @author miaoqi
     * @date 2019-03-10
     * @param
     * @return
     */
    @GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            return "flux data--" + i;
        }));
        return result;
    }

    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return "some string";
    }

}
