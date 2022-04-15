package com.crio.session9.activity3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {  
        
        // Creator a ThreadPool of 10  Fixed Threads
        ExecutorService executorService = Executors.newFixedThreadPool(10); 

        // Runnable Task
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // The execute() method is void and doesn't give any possibility to get the result of a task's execution or to check the task's status (is it running):
        executorService.execute(runnableTask);

        //Callable Task
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        // submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future:
        Future<String> future = executorService.submit(callableTask);
        try {
            System.out.println("Line 38: Response inside future: "+ future.get());
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        //Factorial Callable Tasks
        
        List<FactorialTask> callableTasks = new ArrayList<>(); 
        callableTasks.add(new FactorialTask(5));
        callableTasks.add(new FactorialTask(10));
        callableTasks.add(new FactorialTask(15));


        try {
        // invokeAny() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result of a successful execution of one task (if there was a successful execution):
            Integer result = executorService.invokeAny(callableTasks);
            System.out.println("Line" + result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run, and returns the result of all task executions in the form of a list of objects of type Future:
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callableTasks);
            for (Future<Integer> response : futures){
                System.out.println("Line 73: Factorial:" + response.get());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        // The shutdown() method doesn't cause immediate destruction of the ExecutorService. It will make the ExecutorService stop accepting new tasks and shut down after all running threads finish their current work:
        executorService.shutdown();  

       
    }
}
