package org.example.medical.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger("MedicalCenter");
    public static void logInfo(String msg) { logger.info(msg); }
    public static void logError(String msg) { logger.error(msg); }
}
