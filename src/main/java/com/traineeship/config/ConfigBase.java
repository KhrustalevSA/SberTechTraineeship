package com.traineeship.config;

import com.traineeship.configInterfaces.Config;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Класс для загрузки конфига
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public abstract class ConfigBase implements Config {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CONFIGURATION.name());
    protected final String pathName;
    private final Properties properties = new Properties();

    /**
     * Конструктор - загрузка конфига
     * @param pathName - путь для получения конфига
     */
    protected ConfigBase(String pathName){
        this.pathName = pathName;
        load();
        LOGGER.debug("Конфиг получил путь файла с настройками: " + pathName );
    }

    /**
     * Функция для получения определенной настройки из конфига
     * @param propertyKey  - ключ настройки/имя настройки
     */
    @Override
    public String getProperty(String propertyKey){
        LOGGER.log(Level.INFO, "Получение настройки по ключу:" + propertyKey);

        if (properties.isEmpty()) {
            LOGGER.error("Properties don't found");
            return null;
        } else if (properties.getProperty(propertyKey) == null) {
            LOGGER.error("Property don't found");
            return null;
        } else {
            return properties.getProperty(propertyKey);
        }
    }

    /**
     * Функция загрузки конфига
     * @exception IOException - ошибка чтения файла
     */
    public void load() {
        try {
            File file = new File(pathName);
            properties.load(new FileReader(file));
            LOGGER.debug("Прочитан файл " + file.getName());
        } catch (IOException e){
            LOGGER.error("IOException");

        }
    }

}
