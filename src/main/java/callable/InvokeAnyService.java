package callable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = List.of(
                () -> { Thread.sleep(3000); return "Slow Task"; },
                () -> "Fast Task",
                () -> { throw new Exception("Error in task"); }
        );

        // Returns result of the first successfully completed task
        String result = executor.invokeAny(tasks);
        System.out.println("First successful result: " + result);

        executor.shutdown();
    }
}
