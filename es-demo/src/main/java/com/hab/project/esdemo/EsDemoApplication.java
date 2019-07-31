package com.hab.project.esdemo;

import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 功能：启动类
 *
 * @author huangaibing
 * @date  2019/7/31 11:43
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EsDemoApplication {

    public static void main(String[] args) {
        InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory());
        SpringApplication.run(EsDemoApplication.class, args);
    }

}
