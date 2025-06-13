package in.orenda.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0; i<=5; i++){
            int taskId = i;
            executorService.execute(
                    () -> {
                        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                    }
            );
        }
        executorService.shutdown();
    }
}
