the JVM may **exit immediately after the main method** finishes before the async task completes — even if you’re chaining .thenAccept() and .thenRun().

#### ✅ Why?

CompletableFuture.supplyAsync(...) **by default uses the ForkJoinPool.commonPool()**, which uses daemon threads. 
Daemon threads **do not keep the JVM alive once the main thread is done**

So, use own custom Thread Pool by using ExecutorService Framework

#### 🔧 Creating

1. **supplyAsync**  
      * asynchronously execute a task that returns a result.
      * supplyAsync method will accepts two parameter one is supplier functional interface and  
      * other parameter as executor when you want to manage your own thread pool by using ExecutorService Framework.
2.   **runAsync** 
      * asynchronous code that does NOT return a result
      * runAsync method accepts Runnable and Executors as its argument values
     
#### 🔄 Transformation Methods

1. **thenApply**
      * method is used to **transform the result of a completed CompletableFuture** and **return a new value**. 
      * It takes a Function that **receives the result** and returns a new value. 
      * The returned CompletableFuture contains the transformed result.
2. **thenAccept**
      * used to **consume the result of a completed CompletableFuture** without returning anything.
      * It takes a Consumer that processes the result but **returns void**.
      * The returned CompletableFuture<Void> completes when the consumer finishes
3.  **thenRun**
      * used to run a task after completion that **does not depend on the result of the CompletableFuture** and returns nothing.
      * It takes a Runnable with no arguments and **no return**.
      * The returned CompletableFuture<Void> completes when the runnable finishes.
4.   **thenCompose(fn)**
      * Transforms into another future and flattens it.
      * To avoid nesting CompletableFuture<CompletableFuture<T>>.
Each method has it Async Version

#### 📚 Static Utility Methods
1. **allOf(futures...)**
      * Returns a future that completes when all complete
2. **anyOf(futures...)**
      * Returns a future that completes when any completes.

#### 🔗 Combining Futures
1.  **thenCombine(other, fn)**
      * Combines results from two futures.
      * Combines two future results into one
2.  **thenAcceptBoth(other, consumer)**
      * Consumes both results without **returning**.
3.   **runAfterBoth(other, runnable)**
      * Runs a task after both complete.

#### 😎 Exception Handling
1.  **exceptionally(fn)**
      * Provides fallback in case of exception.
2.  **handle((result, ex) -> ...)**
      * Processes result or exception.
3.   **whenComplete((result, ex) -> ...)**
      * Runs after completion (exception or not).


#### 🧪 Checking Status
1.  **isDone()**
      * Returns true if complete. 
2.  **isCompletedExceptionally()**
      * True if completed with exception.
3.  **isCancelled()**
      * True if cancelled.
4.  **cancel(mayInterruptIfRunning)**
      * Attempts to cancel.
5.  **get()**
      * Blocks and gets result.
6.  **get(timeout, unit)**
      * Gets with timeout.
7.   **join()**
      * Similar to get() but doesn't throw checked exceptions.