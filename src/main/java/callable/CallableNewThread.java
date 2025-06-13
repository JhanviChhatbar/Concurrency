package callable;

import java.util.concurrent.*;

public class CallableNewThread implements Callable {
    @Override
    public Object call() throws Exception {
        return "Thread Testing";
    }
}

class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableNewThread thread = new CallableNewThread();

        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<String> future = service.submit(thread);
        System.out.println(future.get());
        service.shutdown();
    }
}
