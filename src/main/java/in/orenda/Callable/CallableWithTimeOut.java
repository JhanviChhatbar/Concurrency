package in.orenda.Callable;

import java.util.concurrent.*;

public class CallableWithTimeOut {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> delayedTask = () -> {
            Thread.sleep(5000);        //Simulate long task
            return "Completed After delay";
        };

        Future<String> future = executorService.submit(delayedTask);

        try {
            String result = future.get(2, TimeUnit.SECONDS);
        }catch (TimeoutException e) {
            System.out.println("Task timed out!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
