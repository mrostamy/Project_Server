package com.mydomain.project_server.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.mydomain.project_server.repositories.FinancialDB",
        entityManagerFactoryRef = "financialEntityManager",
        transactionManagerRef = "financialTransactionManager"
)
public class Financial_DatabaseConfig {

    @Bean
    public DataSource financialDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/project_financial");
        ds.setUsername("root");
        ds.setPassword("mohammad1234");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean financialEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(financialDataSource());
        em.setPackagesToScan("com.mydomain.project_server.models.FinancialDB");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        Map<String,String> properties=new HashMap<>();

        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");

        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager financialTransactionManager() {

        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(financialEntityManager().getObject());
        return tx;

    }


}
