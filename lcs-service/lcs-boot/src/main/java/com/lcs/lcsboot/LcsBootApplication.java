package com.lcs.lcsboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wl
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
public class LcsBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LcsBootApplication.class, args);
    }

}
