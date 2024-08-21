package com.example.demos.config;

import com.example.demos.model.dao.UserDAO;
import com.example.demos.model.dao.WinnersDAO;
import com.example.demos.model.entities.User;
import com.example.demos.model.entities.Winners;
import org.hibernate.Session;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSourceBuilder")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url("jdbc:mysql://localhost:3306/main_docum\n");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("2231");
        return dataSourceBuilder.build();
    }

    @Bean(name = "configuration")
    public org.hibernate.cfg.Configuration getConfiguration() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Winners.class);

        return configuration;
    }

    @Bean(name = "session")
    public Session getSession() {
        Session session = getConfiguration().buildSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Bean(name = "WinnersDAO")
    public WinnersDAO getWinnersDAO() {
        WinnersDAO winnersDAO = new WinnersDAO();

        return winnersDAO;
    }

    @Bean(name = "UserDAO")
    public UserDAO getUserDAO() {
        UserDAO userDAO = new UserDAO();

        return userDAO;
    }
}