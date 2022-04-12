package com.traineeship.configTest;

import com.traineeship.config.ConfigFactory;
import com.traineeship.config.H2DataBaseConfig;
import com.traineeship.config.MySQLDataBaseConfig;
import com.traineeship.logger.LogFactory;
import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigTest {

    private static final Logger LOGGER = Logger.getLogger(LoggerNames.DATABASE.name());

    @Test
    public void getProperty() throws IOException {
        String key = "jdbc:mysql://localhost:3306/jdbc";

        String property = ConfigFactory.getConfig(MySQLDataBaseConfig.class).getProperty("mySQL_url");

        assertEquals(key, property);
    }

    @Test
    public void getPropertyFall() throws IOException {

        String key = "jdbc:mysql://localhost:3306/jdbc";

        String property = ConfigFactory.getConfig(MySQLDataBaseConfig.class).getProperty("mySQLl_url");

        assertNotEquals(key, property);

    }



    // Тест на падение при вызове несуществующей property Фабрика падает при ошибке загрузки,
    // проперти если не найдено то Выдать ошибку
    // Структурировать пакеты (принципы)
    //Во всем проекте вставить логгирование(log4j),там где try\catch - log.error,там где получение параметров - log.debug
    //LogFactory с методом getLogger(Настроить уровень логгирования) по назаванию метода, уровень логгирования берется из app.properties
}