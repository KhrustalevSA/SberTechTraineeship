package com.traineeship.config;

import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;

/**
 * Класс для работы с конфигом базы данных
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class DataBaseConfig extends ConfigBase {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.DATABASE.name());

    /**
     * Конструктор - Создание объекта ApplicationConfig для работы с конфигом приложения
     * @see ConfigBase#ConfigBase(String)
     */
    protected DataBaseConfig() {
        super("src/main/resources/db.properties");
        LOGGER.info("Загрузился файл db.properties");
    }

}
