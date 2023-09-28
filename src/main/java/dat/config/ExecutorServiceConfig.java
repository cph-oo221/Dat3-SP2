package dat.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceConfig
{
    private static final int THREADS = 4;
    private static ExecutorService executorService;

    public static ExecutorService getExecutorService()
    {
        if (executorService == null)
        {
            executorService = Executors.newFixedThreadPool(THREADS);
        }
        return executorService;
    }
}