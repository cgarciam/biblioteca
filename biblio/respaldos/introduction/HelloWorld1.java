package chapters.introduction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld1 {

	public static void main(String[] args) {

		Logger logger;
		String nameLogger;
		nameLogger = "RAMO #3";
		// logger = LoggerFactory.getLogger(HelloWorld1.class);
		logger = LoggerFactory.getLogger(nameLogger);
		logger.debug("Hello world.");
		logger.trace("This");

	}
}