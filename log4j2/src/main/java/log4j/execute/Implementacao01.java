package log4j.execute;

import org.apache.logging.log4j.Logger;
import java.util.Date;
import org.apache.logging.log4j.LogManager;

public class Implementacao01 {

	private static final Logger logger = LogManager.getLogger(Implementacao01.class);

	public static void main(final String... args) {
		for (int i = 0; i < 1000; i++) {
			logger.info(new Date().toInstant().toString());

			logger.warn("Anything that can potentially cause application oddities, but for which I am automatically recovering. (Such as switching from a primary to backup server, retrying an operation, missing secondary data, etc.)");
			logger.error("Any error which is fatal to the operation, but not the service or application (can't open a required file, missing data, etc.).");
			logger.info("Generally useful information to log (service start/stop, configuration assumptions, etc).");
			logger.debug("Information that is diagnostically helpful to people more than just developers (IT, sysadmins, etc.).");
			logger.trace("Trace - Only when I would be 'tracing' the code and trying to find one part of a function specifically.");
			logger.fatal("Any error that is forcing a shutdown of the service or application to prevent data loss (or further data loss).");
		}
		logger.info("Exiting application. \n-------------------");
	}

}
