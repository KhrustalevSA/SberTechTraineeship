package com.traineeship.config;

import com.traineeship.configInterfaces.Config;
import com.traineeship.logger.LoggerNames;
import org.apache.log4j.Logger;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с конфигами
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class ConfigFactory {
    private static final Logger LOGGER = Logger.getLogger(LoggerNames.CONFIGURATION.name());
    private static final Map<Class, Config> configMap = new HashMap<>();

    static{
        configMap.put(ApplicationConfig.class,loadConfig(ApplicationConfig.class));
        configMap.put(DataBaseConfig.class,loadConfig(DataBaseConfig.class));
        LOGGER.info("Все конфиги загрузились");
    }

    /**
     * Функция получения конфига
     * @param clazz - класс получаемого конфига
     */
    public static Config getConfig(Class<?extends Config> clazz ){

        LOGGER.info("Получение конфига из списка");
        return configMap.get(clazz);
    }

    /**
     * Функция загрузки конфига
     * @param clazz - класс загружаемого конфига
     */
    private static Config loadConfig(Class<?extends Config> clazz ){

        try {
            Constructor<?extends Config> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            LOGGER.info("Загрузка конфига");
            return constructor.newInstance();
        } catch (Exception exception){
            LOGGER.error("Ошибка загрузки конфига");
        }
        return null;
    }
}
