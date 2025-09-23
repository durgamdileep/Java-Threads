### Future Interface: The Foundation of Asynchronous Results 🏗️

The Future interface, introduced in Java 5, represents the **result of an asynchronous computation**.  
It provides a way to check if the computation is complete, wait for its completion, and retrieve the result.

#### Key Features of Future 🔑
1. **Result Retrieval**: Allows access to the result of an asynchronous operation once it's available. 📊
2. **Status Checking**: Provides methods to check if a task has completed or been cancelled. ✅
3. **Cancellation**: Supports cancellation of tasks that haven't started or are in progress. ❌ 

    **Explanation :**
      * cancel(true) tries to interrupt if the task is running.
      * You should check Thread.interrupted() inside your task to make cancellation responsive because :
      * When you call future.cancel(true), it sends an interrupt signal to the thread running the task.
      * But Java doesn’t forcefully stop a thread — it just sets the interrupted flag.
      * So your task must periodically check if it has been interrupted using Thread.interrupted().
      * If you don’t check it, the task will keep running, even if you cancel it.

4. Blocking Operations: Primarily uses blocking methods that wait for task completion. ⏳

   **Explanation :**
      * future.get() blocks until the task completes. 
      * Use get(long timeout, TimeUnit unit) if you want to avoid indefinite blocking as :
      * **future.get() blocks the current thread until the task completes** — this could take forever if the task hangs. 
      * **future.get(timeout, unit)** adds a maximum wait time. 
      * If the result isn’t ready in that time, it throws a **TimeoutException**, and your thread can recover gracefully instead of hanging forever.



### Limitations of Future in Java

1. No Composition 🔗❌
      *  Future does not support chaining multiple tasks together.  
         You cannot specify a dependent task that should execute once the Future completes, making it difficult to manage sequential asynchronous computations.
2. No Exception Handling ⚠️
      *  There is no built-in mechanism to handle exceptions in Future.
      * If an exception occurs during execution, you must manually catch it using get(), which can make error handling cumbersome.
3. Blocking Operations 🛑
      *  Calling get() on a Future blocks the current thread until the result is available, leading to potential performance issues if the task takes too long to complete.
4. No Completion Notification 🔔❌
      * Future does not provide an event-driven mechanism to notify when a task completes.
      * You must explicitly poll or call get(), which is inefficient compared to reactive approaches.

This is why CompletableFuture is preferred, as it addresses these limitations with features like chaining, exception handling, and non-blocking callbacks.