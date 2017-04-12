package com.example.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.Properties;

//region Data Source Config
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class AppConfig {
    @Bean(name="ds")
     DataSource dataSource(Environment env) throws SQLException{
        DriverManagerDataSource mysql = new DriverManagerDataSource();
        mysql.setDriverClassName(env.getRequiredProperty("spring.datasource.dbcp2.driver"));
        mysql.setUrl(env.getRequiredProperty("spring.datasource.url"));
        mysql.setUsername(env.getRequiredProperty("spring.datasource.username"));
        mysql.setPassword(env.getRequiredProperty("spring.datasource.password"));
        return mysql;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds, Environment env){
        LocalContainerEntityManagerFactoryBean entityBean = new LocalContainerEntityManagerFactoryBean();

        entityBean.setDataSource(ds);
        entityBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityBean.setPackagesToScan("com.example.Models");

        Properties props = new Properties();

        props.put("spring.jooq.sql-dialect", env.getRequiredProperty("spring.jooq.sql-dialect"));
        props.put("spring.jpa.hibernate.ddl-auto",env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));

        entityBean.setJpaProperties(props);

        return entityBean;

    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf);
        return tm;
    }
//endregion



}
