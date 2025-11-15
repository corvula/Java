package org.example.medical.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger("medical-center");

    private LoggerUtil() {}

    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logError(String msg) {
        logger.error(msg);
    }

    public static void logDebug(String msg) {
        logger.debug(msg);
    }
}
