package com.traineeship.config;

import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;

/**
 * Класс для работы с конфигом базы данных
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class MySQLDataBaseConfig extends ConfigBase {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.DATABASE.name());

    /**
     * Конструктор - Создание объекта ConfigBase для работы с конфигом приложения
     * @see ConfigBase#ConfigBase(String)
     */
    protected MySQLDataBaseConfig() {
        super("src/main/resources/mySQL.properties");
        LOGGER.debug("Загрузился файл mySQL.properties");
    }

}
