package threadPool;

import java.util.concurrent.*;

public class CallableThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> task = () -> {
            Thread.sleep(5000);
            return "Task Completed";
        };

        Future<String> result = executorService.submit(task);

        System.out.println(result.get());

        executorService.shutdown();


    }
}
