package co.com.bancodebogota.utlidades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSleep {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadSleep.class);

    private ThreadSleep() {
        LOGGER.info("ThreadSleep");
        throw new IllegalStateException("Utility class");
    }

    public static void thread(int tiempoDeEspera) throws InterruptedException {
        Thread.sleep(tiempoDeEspera);
    }
}
