package com.example.from_zero_to_hero.multithreading;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialCalculator factorialCalculator = new FactorialCalculator(5);
        Future<Integer> future = executorService.submit(factorialCalculator);
        try {
            System.out.println(future.isDone());
            System.out.println("Want to get a result");
            factorialResult = future.get();
            System.out.println("Fetched a result");
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class FactorialCalculator implements Callable<Integer> {
    int f;

    public FactorialCalculator(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Invalid factorial number");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}
