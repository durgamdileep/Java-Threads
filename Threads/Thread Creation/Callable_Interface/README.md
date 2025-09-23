#### 🔹 throws Keyword
   * Used in the **method signature**.
   * Declares that the **method `might throw` one or more exceptions**.
   * Used primarily with checked exceptions (which must be either caught or declared)

#### 🔹 throw Keyword
   * Used inside a method or block of code.
   * throw to **`actually throw`** an exception.
   * You create and **throw an instance of an exception** (checked or unchecked).
   * **Only one exception** can be thrown at a time.



### Checked vs Unchecked Exceptions in Java :  

### Checked Exceptions :
1.  Checked exceptions are exceptions that **must be either declared in the method signature using throws or handled using try-catch.**
2. They are checked at compile-time. 
3. Examples: 
      * IOException (e.g., file not found) 
      * SQLException (e.g., database connection failure) 
      * InterruptedException (e.g., thread interruption)
### Unchecked Exceptions :
1. Unchecked exceptions are runtime errors that **do not require explicit handling**. 
2. They are checked at runtime, meaning they occur due to logical errors in the program. 
3. Examples: 
     * NullPointerException (e.g., calling a method on null) 
     * ArrayIndexOutOfBoundsException (e.g., accessing an invalid array index) 
     * ArithmeticException (e.g., division by zero) 


#### Key Difference:
   * Checked exceptions enforce error handling at compile-time.
   * while unchecked exceptions indicate programming mistakes that occur at runtime. 🚀

### Using the Callable Interface 📞 
The Callable interface, introduced in Java 5 as part of the concurrency utilities, provides a more powerful alternative to Runnable.  
Unlike Runnable, Callable can return results and throw checked exceptions.

#### Key Features of Callable 🔑

* Return Values: Callable tasks can return results, unlike Runnable tasks which return void. 
* Exception Handling: Callable's call() method can throw checked exceptions, while Runnable's run() method cannot. 
* Future Objects: Callable works with Future objects to retrieve results after task completion. 

### How Callable Works ?

The Callable interface works with the **ExecutorService framework** rather than directly extending Thread. 