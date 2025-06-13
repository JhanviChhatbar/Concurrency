package in.orenda.Callable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCallable {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Async Result";
                }).thenApply(result -> result.toUpperCase())
                .thenAccept(System.out::println); // prints ASYNC RESULT

        try {
            Thread.sleep(2000); // wait for async chain to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
