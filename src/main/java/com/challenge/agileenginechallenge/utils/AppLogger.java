package com.challenge.agileenginechallenge.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logger class to log messages
 * Easy to change the logger implementation
 * Like kafka, logstash, etc
 */

public class AppLogger {

    private final Logger log;

    public AppLogger(Class<?> clazz) {
        log = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        log.info(message);
    }

    public void error(String message) {
        log.error(message);
    }

    public void debug(String message) {
        log.debug(message);
    }

    public void warn(String message) {
        log.warn(message);
    }
}