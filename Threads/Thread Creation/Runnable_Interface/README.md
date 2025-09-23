### 2. Implementing the Runnable Interface 🔄

The Runnable interface provides a more flexible approach to creating threads. It separates the task from the thread itself, promoting better object-oriented design and allowing a class to extend another class while still being runnable in a separate thread. 

Advantages:

* Better object-oriented design 
* Allows class to extend other classes 
* Same Runnable instance can be shared across multiple threads 
* `More flexible` for `executor frameworks` 

Disadvantages:

* Slightly more code to write 
* `Indirect access` to `Thread methods` 
