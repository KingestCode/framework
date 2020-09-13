package com.miaoqi.spring.springwebflux.test;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;

public class ReactorDemo {

    public static void main(String[] args) throws InterruptedException {
        // reactor = java8 stream + java9 reactive stream
        // Mono 0-1个元素
        // Flux 0-N个元素
        String[] str = {"1", "2", "3"};

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription s) {
                // 保存订阅关系, 需要用它来给发布者响应
                this.subscription = s;

                // 请求一个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer integer) {
                // 接受到一个数据, 处理
                System.out.println("接受到数据: " + integer);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 处理完调用request再请求一个数据
                this.subscription.request(1);

                // 或者已经达到了目标, 调用cancel告诉发布者不再接收数据了
                // this.subscription.cancel();
            }

            @Override
            public void onError(Throwable t) {
                // 出现了异常(例如处理数据的时候产生了异常)
                t.printStackTrace();

                // 我们可以告诉发布者, 后面不接收数据了
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                // 全部数据处理完了(发布者关闭了)
                System.out.println("处理完了");
            }
        };

        // 这里是jdk8的stream
        Flux.fromArray(str).map(Integer::parseInt)
        // 最终操作
        // 这里就是jdk9的reactive stream
        .subscribe(subscriber);
    }

}
