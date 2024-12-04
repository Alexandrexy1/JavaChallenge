package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Client;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        Map<String, String> envConfig = new LinkedHashMap<>();

        envConfig.put("hibernate.dialect", dotenv.get("HIBERNATE_DIALECT"));
        envConfig.put("hibernate.hbm2ddl.auto", dotenv.get("HIBERNATE_DDL_AUTO"));
        envConfig.put("hibernate.show_sql", dotenv.get("HIBERNATE_SHOW_SQL"));
        envConfig.put("hibernate.format_sql", dotenv.get("HIBERNATE_FORMAT_SQL"));
        envConfig.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        envConfig.put("jakarta.persistence.jdbc.url", dotenv.get("DB_URL"));
        envConfig.put("jakarta.persistence.jdbc.user", dotenv.get("DB_USER"));
        envConfig.put("jakarta.persistence.jdbc.password", dotenv.get("DB_PASSWORD"));

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("study-jpa", envConfig);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Client client1 = new Client("Joao", 29);
        Client client2 = new Client("Maria", 25);

        entityManager.getTransaction().begin();
        entityManager.persist(client1);
        entityManager.persist(client2);
        entityManager.getTransaction().commit();

        Client dbClient = entityManager.find(Client.class, 1);
        Client dbClient1 = entityManager.find(Client.class, 2);

        System.out.println(dbClient);
        System.out.println(dbClient1);

        entityManager.close();
    }
}