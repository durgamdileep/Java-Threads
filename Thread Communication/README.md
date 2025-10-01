## Thread Communication in Java 🧵💬

Thread communication is a fundamental concept in concurrent programming that **allows multiple threads to coordinate and share data effectively**.  
Proper thread communication is essential for building robust, efficient, and thread-safe applications. 🚀🔒

### 🧰 Methods of Thread Communication:

### 🛑 wait(), 🟡 notify(), and 🔁 notifyAll() Methods:

These methods work with a thread’s monitor (**the intrinsic lock on an object**) to coordinate the execution between threads.  
They are used when one or more threads need to wait for a specific condition to occur while another thread notifies them of the change.

### 1. ⏸️ wait():

When a thread calls the wait() method on an object, it releases the monitor (lock) it holds on that object and goes into a waiting state.

🔁 Use wait() when a thread needs to pause execution until some condition (usually represented by a shared variable) changes.  
For example, a consumer thread might wait for a producer to produce an item.
 
**Always Use the wait() method inside a loop** **to avoid issues caused by spurious wakeups**,  
which occur when the Java runtime randomly wakes up a waiting thread without a notify() or notifyAll() call.
This happens very rarely and is difficult to simulate in tests.

### 2. 🔔 notify():

The notify() method wakes up a single thread that is waiting on the object’s monitor.  
If more than one thread is waiting, the scheduler chooses one arbitrarily.  
🎯 Use notify() when only one waiting thread needs to be awakened (e.g., when one resource becomes available) to continue its execution.

### 3. 📣 notifyAll():

The notifyAll() method wakes up all threads that are waiting on the object’s monitor.  
👥 Use notifyAll() when a change in the condition may be relevant to all waiting threads.  
For instance, when a producer adds an item to a queue that multiple consumers might be waiting for, you want to wake all waiting threads so they can re-check the condition.

## ⚠️ Important:

These methods must be called from within a `synchronized context` (a synchronized block or method) on the same object whose monitor the thread is waiting on.  
They work together with a shared condition (often a flag or another shared variable) that threads check in a loop to handle spurious wakeups. 🔄🔍


# Interview Questions:

### 1. Can you explain the producer-consumer problem and how to solve it using thread communication? 🧵❗

The producer-consumer problems a classic example of inter-thread communication and synchronization in Java.  
It involves a producer that generates data (or items) and a consumer that processes those items.

A shared bounded buffer (or queue) is used to store the items. The challenge is to coordinate the producer and consumer so that:

* The producer waits when the buffer is full (to avoid overfilling).
* The consumer waits when the buffer is empty (to avoid consuming a non-existent item).

Inter-thread communication methods—wait(), notify(), and notifyAll()—are used to achieve this coordination. ✅

### 2. How does thread interruption work with communication methods? 🧵❗

Answer: When a thread is waiting (using wait(), join(), or blocking queue methods),  
it can be interrupted by another thread calling its interrupt() method.  
This causes an InterruptedException to be thrown, allowing the waiting thread to handle the interruption.  
Proper handling involves either re-interrupting the thread or propagating the exception.

---

# 🧵 Java Threading: join(), wait(), and yield()

---

## 🔍 1. `join()` – Does Not Release Locks

### How it works:

When you call `thread.join()`, the current thread pauses until the thread is finished.

But if you're holding a lock (synchronized block or method) while calling `join()`, you continue to hold the lock during the wait.

🚫 That means:

- Other threads trying to access that same lock will be blocked.
- Can lead to deadlocks or performance issues if used carelessly inside synchronized code.

---

## 🔍 2. `wait()` – Releases Lock

- `wait()` is called on an object you're synchronizing on.
- When a thread calls `wait()`, it:

  ✅ Releases the lock on that object  
  ⏳ Waits until it's notified (`notify()` or `notifyAll()`)  
  🔒 Reacquires the lock before resuming

✅ That makes it safe for communication between threads.

---

## 🧰 `Thread.yield()` 

### 🔧 Behavior:

It tells the thread scheduler:

> “I'm okay stepping aside for a bit. If any other threads of the same or higher priority are waiting, let them run.”

But:

- ❌ It does **NOT** stop the thread permanently.
- ❌ It does **NOT** release any locks.
- 💡 It’s just a hint — the scheduler **may ignore it completely**.

---

## 🕰️ How long does a thread wait when using `yield()`?

- 🔸 There is no fixed time.
- 🔸 `Thread.yield()` just hints to the JVM that the current thread is willing to give up the CPU temporarily, but:

  - ⏱️ It may resume immediately  
  - ⏱️ It may resume after a short pause  
  - ❓ It may not yield at all  

---
