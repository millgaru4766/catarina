package com.meeple.catarina;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogBack {
	public static final Logger consoleLogger = LoggerFactory.getLogger(LogBack.class);
	public static final Logger errorLogger = LoggerFactory.getLogger("ERROR_LOGGER");
	public static final Logger requestLogger = LoggerFactory.getLogger("REQUEST_LOGGER");

	@Test
	public void logBack() {
			MDC.put("LoginUser", "Hyohun");
			consoleLogger.info("userId info");
			
			
			consoleLogger.info("clear userId info");
			requestLogger.info("info request log");
			errorLogger.info("error info log");
			errorLogger.error("error log");
			try {
				throw new Exception();
			} catch (Exception e) {
				errorLogger.error(e.toString());
			}
		}
}
