package com.traineeship.logger;

import org.apache.log4j.Logger;

/**
 * Класс для работы с логгерами
 * @author Khrustalev-sa
 * @since 27.02.2022
 */
public class LogFactory {

    /**
     * Функция получения логгера CONFIGURATION
     * @return Logger.getLogger(LoggerNames.CONFIGURATION.name()) - имя логгера
     */
    public static Logger getConfigLogger() {return  Logger.getLogger(LoggerNames.CONFIGURATION.name());}

    /**
     * Функция получения логгера DATABASE
     * @return Logger.getLogger(LoggerNames.DATABASE.name()) - имя логгера
     */
    public static Logger getDatabaseLogger(){return Logger.getLogger(LoggerNames.DATABASE.name());}

    /**
     * Функция получения логгера CORE
     * @return Logger.getLogger(LoggerNames.CORE.name()) - имя логгера
     */
    public static Logger getLogger() {
        return Logger.getLogger(LoggerNames.CORE.name());
    }
}
