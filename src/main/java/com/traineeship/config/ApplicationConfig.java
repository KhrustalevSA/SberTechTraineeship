package com.traineeship.config;

import com.traineeship.logger.LoggerNames;
import com.traineeship.project.StudentImpl;
import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * Класс для работы с конфигом приложения
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class ApplicationConfig extends ConfigBase {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CORE.name());

    /**
     * Конструктор - Создание объекта ApplicationConfig для работы с конфигом приложения
     * @see ConfigBase#ConfigBase(String)
     */
    protected ApplicationConfig() {
        super("src/main/resources/app.properties");
        LOGGER.info("Загрузился файл app.properties");
    }
}
