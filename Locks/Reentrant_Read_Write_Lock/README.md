### ReentrantReadWriteLock (Read‑Write Lock) 🔒 :

ReentrantReadWriteLock(found in the java.util.concurrent.lockspackage) divides the lock into two parts—a read lock and a write lock. It is useful when:

* **Multiple Threads Need to Read:** 👥 They can do so concurrently if there’s no writing.
* **Exclusive Writing ✍️:** When a thread is updating data, no other thread (reader or writer) is allowed to access the resource.

It is used to improve performance in scenarios with many more read operations than writes.


### What is the difference between synchronized and Reentrant Lock? 🔄🔒

### 1. Acquisition and Flexibility: 🚦

#### Synchronized:

* The synchronized keyword is built into the language; it automatically acquires and releases the intrinsic lock (monitor) of an object. 🔄
* It is simple to use but offers only blocking behavior—it always waits indefinitely to acquire the lock. ⏳
* You cannot try to acquire a synchronized lock with a timeout or check if the lock is available (i.e., no non‑blocking acquisition). ❌

#### ReentrantLock:

* Part of the java.util.concurrent.lockspackage, ReentrantLock provides explicit lock management. 🛠️
* It gives you extra flexibility—for instance, with methods such as tryLock()(with or without a timeout) you can attempt to acquire the lock in a non‑blocking manner. ⏱️
* It also supports interruptible lock acquisition (lockInterruptibly()) and fairness policies. ⚖️


### 2. Automatic vs. Manual Release: 🔄🆚👐

#### Synchronized:

* The lock is automatically released when the synchronized block or method exits (even if an exception occurs). 🔄

#### ReentrantLock:

* You must explicitly call unlock()(usually in a finally block) to ensure that the lock is released. This gives you additional control but also adds responsibility. 🔑
