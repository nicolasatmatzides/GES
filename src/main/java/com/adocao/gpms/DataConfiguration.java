package com.adocao.gpms;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.xerces.util.URI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@Configuration
public class DataConfiguration {
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException, URI.MalformedURIException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserinfo().split(":")[0];
        String password = dbUri.getUserinfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
