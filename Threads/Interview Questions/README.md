
# Interview Questions 🎯

### 1. What is the difference between start() and run() methods?

Answer: The start() method `begins new thread` of execution and `calls the run() method internally` , while the run() method simply contains the code to be executed.  
Directly calling run() won't create a new thread; it will execute in the current thread. 🔄 

### 2. Can we call the start() method twice on the same Thread object?

Answer: No, calling start() twice on the same Thread object will throw an IllegalThreadStateException.  
A thread that has completed execution cannot be restarted. ⚠️

### 3. What is thread safety and how can it be achieved?

Answer: Thread safety refers to code that functions correctly during simultaneous execution by multiple threads.  
It can be achieved through synchronization, immutable objects, concurrent collections, atomic variables, and thread-local variables. 🔒 

### 4. What happens if an exception occurs in a thread's run method?

Answer: If an uncaught exception occurs in a thread's run() method, the thread terminates.  
The exception doesn't propagate to the parent thread and doesn't affect other threads. ❌

#### Explanation:

* If you call t.run(); directly, it behaves like a normal method call and executes in the main thread, so the exception would be thrown in the main thread.
* By calling t.start();, the thread runs separately, and if an exception occurs in run(), it terminates that thread without affecting the main thread.
* The main thread continues execution and prints "Main thread is running" even if the child thread throws an exception.

### 5. What's the difference between sleep() and wait()?

Answer: 
sleep() causes the current thread to pause for a specified time **without releasing locks**.  
wait() causes the current thread
to wait until another thread invokes notify() or notifyAll() on the same object,  
and it **releases the lock** on the object. 😴 

#### Explanation:

##### What Happens to the Resource a Thread Was Holding when the sleep() method is called?  

* When a thread calls sleep(), it pauses execution for the specified time.
* However, it **does NOT release any locks** it was holding.
* Other threads cannot access synchronized resources held by the sleeping thread. 

##### What Happens to the Resource a Thread Was Holding when the wait() method is called?  

* When a thread calls wait(), it **releases the lock** on the synchronized object it was holding. 
* **Other threads can now acquire the lock and continue execution**. 
* The waiting thread **remains idle until** another thread calls notify() or notifyAll(). 


##### What Happens to the Idle Thread Once notify() or notifyAll() is Called? 

When notify() or notifyAll() is called, **the waiting thread does not immediately start running.** Instead, it follows these steps:

1. When another thread calls notify(), one waiting thread is moved to the Blocked (or Runnable) State, but it does not start execution immediately. 
2. The notified thread cannot resume execution until it successfully acquires the lock on the synchronized object. 
3. If multiple threads are waiting, only one gets notified by notify(), while notifyAll() wakes up all waiting threads (but they still compete for the lock). 
4. Once the thread reacquires the lock, it continues execution from where it called wait().


##### What If We Use notifyAll()? 

If we replace notify(); with notifyAll();, all waiting threads will be notified,  
but only one will acquire the lock first as they will compete for the lock, and **execution depends on the thread scheduler**.

### 6. What is the Callable interface, and how does it differ from Runnable?

Answer: Callable is a functional interface introduced in Java 5 as part of the concurrency utilities. The key differences from Runnable are:
   * Callable's call() method can return a result (it's a parameterized type), while Runnable's run() method returns void 
   * Callable's call() method can throw checked exceptions, while Runnable's run() method cannot 
   * Callable works with Future objects to handle the results asynchronously 

### 7. Can you use Callable with standard Thread objects?
Answer: No, you cannot directly use Callable with the Thread class. Callable is **designed to work with the ExecutorService framework**.  
**Thread class only accepts Runnable objects**.  
However, you can adapt a Callable to work with Thread by creating a Runnable that executes the Callable and stores its result: 




## Threads using the same object are synchronized and execute one by one.

## Threads using different objects can execute concurrently
