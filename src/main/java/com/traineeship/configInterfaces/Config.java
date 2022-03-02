package com.traineeship.configInterfaces;

/**
 * Интерфес для получения настройки конфига
 * @author popovtsev-pv
 * @since 06.10.2021
 */
public interface Config {
    public String getProperty(String propertyKey);
}
