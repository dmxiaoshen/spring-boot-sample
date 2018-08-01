//package com.dmxiaoshen;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.embedded.RedisServer;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.IOException;
//
//
//@Configuration
//public class RedisTestConfig {
//
//    private RedisServer redisServer;
//
//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;
//
//    @PostConstruct
//    public void init() throws IOException{
//        //setting("maxheap 512000")
//        this.redisServer = RedisServer.builder().setting("maxheap 512Mb").port(6379).build();
//        if(!this.redisServer.isActive()){
//            this.redisServer.start();
//            redisTemplate.getConnectionFactory().getConnection();
//        }
//    }
//
//    @PreDestroy
//    public void destory(){
//        if(this.redisServer.isActive()){
//            this.redisServer.stop();
//        }
//    }
//}
