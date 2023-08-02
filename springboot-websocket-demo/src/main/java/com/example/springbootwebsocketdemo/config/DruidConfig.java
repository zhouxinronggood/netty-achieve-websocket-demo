package com.example.springbootwebsocketdemo.config;

import cn.hutool.core.codec.Base64;
import com.alibaba.druid.pool.DruidDataSource;
import com.example.springbootwebsocketdemo.util.CryptoUtil;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description 数据源信息配置类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
@Configuration
@RefreshScope
@Data
@Log4j2
public class DruidConfig {

    @Value("${spring.datasource.druid.url}")
    private String url;

    @Value("${spring.datasource.druid.username}")
    private String username;

    @Value("${spring.datasource.druid.password}")
    private String password;

    @Value("${spring.datasource.druid.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.druid.initial-size:10}")
    private Integer initialSize;

    @Value("${spring.datasource.druid.max-active:50}")
    private Integer maxActive;

    @Value("${spring.datasource.druid.min-idle:10}")
    private Integer minIdle;

    @Value("${spring.datasource.druid.max-wait:60000}")
    private Integer maxWait;

    @Value("${spring.datasource.druid.pool-prepared-statements:true}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.druid.max-pool-prepared-statement-per-connection-size:20}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.druid.validation-query:SELECT 1 FROM DUAL}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-on-borrow:false}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return:false}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.test-while-idle:true}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis::60000}")
    private Integer timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.filters:stat,wall}")
    private String filters;

    @Value("${spring.datasource.druid.connection-properties:}")
    private String connectionProperties;

    @Bean(name = "datasource")
    @RefreshScope
    public DruidDataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        log.info("database's url is {}", this.url);
        datasource.setUrl(this.url);
        datasource.setUsername(this.username);
       /*if (Base64.isBase64(this.password)) {
            log.info("The password is encrypted. Start decrypting...");
            // 解密
            this.password = CryptoUtil.decodePassword(this.password);
        }*/
        datasource.setPassword(this.password);
        datasource.setDriverClassName(this.driverClassName);
        datasource.setInitialSize(this.initialSize);
        datasource.setMaxActive(maxActive);
        datasource.setMinIdle(minIdle);
        datasource.setMaxWait(maxWait);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setConnectionProperties(connectionProperties);
        try {
            datasource.setFilters(filters);
            datasource.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("<----------- The dataSource initialization is complete ---------->");
        return datasource;
    }

    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new CustomDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("MySQL", "mysql");
        p.setProperty("PostgreSQL", "opengauss");
        p.setProperty("GoldenDB","goldendb");
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }
}
