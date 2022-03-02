package com.traineeship.configTest;

import com.traineeship.config.ConfigFactory;
import com.traineeship.config.DataBaseConfig;
import com.traineeship.logger.LogFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void getProperty() throws IOException {
        LogFactory logFactory = new LogFactory();
        Logger.getLogger(ConfigFactory.class.getName());
        String key = "jdbc:h2:mem:test";

        String property = ConfigFactory.getConfig(DataBaseConfig.class).getProperty("db_url");

        assertEquals(key, property);
    }

    @Test
    public void getPropertyFall() throws IOException {



    }



    // Тест на падение при вызове несуществующей property Фабрика падает при ошибке загрузки,
    // проперти если не найдено то Выдать ошибку
    // Структурировать пакеты (принципы)
    //Во всем проекте вставить логгирование(log4j),там где try\catch - log.error,там где получение параметров - log.debug
    //LogFactory с методом getLogger(Настроить уровень логгирования) по назаванию метода, уровень логгирования берется из app.properties
}