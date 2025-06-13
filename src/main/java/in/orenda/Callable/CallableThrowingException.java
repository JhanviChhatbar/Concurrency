package in.orenda.Callable;

import java.util.concurrent.*;

public class CallableThrowingException {

    public static void main(String[] args) {

        Callable<Integer> callable = () -> {
            if(true) throw new Exception("Something went wrong");
            return 22;
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(callable);

        try {
            System.out.println(future.get());
        } catch (ExecutionException | InterruptedException e){
            System.out.println("Caught exception " + e.getCause());
        } finally {
            executorService.shutdown();
        }
    }
}
