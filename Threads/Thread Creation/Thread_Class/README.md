### 1. Extending the Thread Class 🧬

The Thread class provides the foundation for creating and managing threads in Java.  
By `extending` this class, you can override the run() method to define the code that will be executed in a separate thread.

Advantages:
* Simpler to implement for beginners 
* `Direct access to Thread methods`

Disadvantages:
* Limits inheritance (Java doesn't support multiple inheritance) 
* `Each task` requires a `new thread instance` 
