package callable;

import java.util.List;
import java.util.concurrent.*;

public class InvokeAllService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = List.of(
                () -> {return "Task 1";},
                () -> "Task 2 ",
                () -> "Task 3 "
        );

        List<Future<String>> futures = executorService.invokeAll(tasks);

        for (Future future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
