package com.crdt.creditapi.dbconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManager",
        transactionManagerRef = "transactionManager",
        basePackages = {"com.crdt.creditapi.repositories"}
)
public class AppDbConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

//    @Value("${spring.datasource.username}")
//    private String dbUsername;
//
//    @Value("${spring.datasource.password}")
//    private String dbPassword;

    @Primary
    @Qualifier("dataSource")
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(dbUrl)
//                .username(dbUsername)
//                .password(dbPassword)
                .build();
    }

    @Primary
    @Bean(name = "entityManager")
    public LocalContainerEntityManagerFactoryBean entityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.crdt.creditapi.entities")
                .persistenceUnit("entityManager")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManager") EntityManagerFactory entityManager
    ) {
        return new JpaTransactionManager(entityManager);
    }
}
