package in.orenda.Callable;

import java.util.concurrent.*;

public class CallableLambdaThread {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            return "Callable Lambda Test";
        };

        //Callable<String> callable = () -> "Callable Lambda Test";   // above and this both are same

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callable);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
