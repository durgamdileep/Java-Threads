# Locks and Types of Locks in Java: Mastering Concurrency Control 🔒🔑

## Why Use Explicit Locks? 🤔

The synchronized keyword has been part of Java since its inception, so why use explicit locks? Explicit locks offer several advantages:

• Greater flexibility:

Fine-grained control over lock acquisition and release 🔄

‍
• Non-block-structured locking:

Acquire and release locks in different scopes 🔓

‍

• Timed lock attempts:

Try to acquire a lock for a specified duration ⏱️

‍

• Interruptible lock acquisition:

Allow threads to be interrupted while waiting for locks 🛑

‍

• Non-ownership releases:

Release locks from different threads (with caution) 👥

• Multiple condition variables:

Associate multiple conditions with a single lock 📋

‍

• Fairness policies:

Optional first-come-first-served lock acquisition 🎯

---

## The Lock Interface Hierarchy 🏛️

The java.util.concurrent.locks package provides a rich set of interfaces and implementations:

### 1. 🔐Locks & ReentrantLock : 

Locks in Java (via the Lock interface) offer more flexible and fine‑grained control over synchronization than the built‑in synchronized keyword. One of the most popular implementations is ReentrantLock, which is called “reentrant” because the thread that holds the lock can re‑acquire it without causing deadlock 🔁.

‍

It provides additional capabilities such as:

• ⚠️ Interruptible Lock Acquisition: Using lockInterruptibly()

• ⏳ Try-Lock Methods: With or without timeouts

• ⚖️ Fairness Policies: To ensure threads acquire locks in the order requested

‍

It is used when you need advanced control over locking 🧠 (e.g., trying to acquire a lock and/or setting up fairness) or when a portion of a critical section is complex and may require more nuanced lock handling 🧩

---

## What is the difference between synchronized and Reentrant Lock? 🔄🔒

### 1. Acquisition and Flexibility: 🚦

**synchronized:**

• The synchronized keyword is built into the language; it automatically acquires and releases the intrinsic lock (monitor) of an object. 🔄

• It is simple to use but offers only blocking behavior—it always waits indefinitely to acquire the lock. ⏳

• You cannot try to acquire a synchronized lock with a timeout or check if the lock is available (i.e., no non‑blocking acquisition). ❌

‍

**ReentrantLock:**

• Part of the java.util.concurrent.lockspackage, ReentrantLock provides explicit lock management. 🛠️

• It gives you extra flexibility—for instance, with methods such as tryLock()(with or without a timeout) you can attempt to acquire the lock in a non‑blocking manner. ⏱️

• It also supports interruptible lock acquisition (lockInterruptibly()) and fairness policies. ⚖️

‍‍

### 2. Automatic vs. Manual Release: 🔄🆚👐

**synchronized:**

• The lock is automatically released when the synchronized block or method exits (even if an exception occurs). 🔄

**ReentrantLock:**

• You must explicitly call unlock()(usually in a finallyblock) to ensure that the lock is released. This gives you additional control but also adds responsibility. 🔑

---

**synchronized:**

• Would force Task‑B to wait indefinitely until Task‑A releases the lock. ⏳

• Lacks the non‑blocking or timed acquisition option. ❌

‍

**ReentrantLock:**

• With tryLock(long time, TimeUnit unit), Task‑B can attempt to acquire the lock but proceed (or take alternate action) if it's not available within a specified timeout. ⏱️

• Offers greater flexibility and control over lock acquisition and release. 🎛️

---

# 🔐 Locking in Java Concurrency

When working with multithreading in Java, understanding how different locking methods behave is crucial — especially when it comes to **interruption handling**.

---

## ❌ `lock()` - Cannot Be Interrupted

- 🚫 **Cannot be interrupted** while waiting for the lock.
- 🕰️ Causes the thread to **wait indefinitely**.
- 🔁 Thread remains **stuck in the queue** if the lock is never released.
- 🧱 This can lead to **deadlocks** or unresponsive systems.

> ⚠️ Use with caution when thread interruption or responsiveness is important.

---

## ✅ `lockInterruptibly()` / `tryLock()` - Can Be Interrupted

### `lockInterruptibly()`
- 🟢 **Can be interrupted** while waiting for the lock.
- 💥 If the thread is interrupted while waiting, it **throws `InterruptedException`**.
- 🔄 Enables responsive systems by allowing a thread to **back out gracefully**.

### `tryLock()`
- ⏳ **Tries to acquire the lock** within a timeout (optional).
- ✅ If lock is available → acquires it.
- ❌ If not → either returns `false` or throws an exception (if interrupted).
- 🕵️ Useful for **avoiding deadlocks** and improving responsiveness.

---

## 🔄 Summary Table

| Method               | Interruptible | Waits Indefinitely | Timeout Support | Notes                         |
|----------------------|---------------|---------------------|------------------|-------------------------------|
| `lock()`             | ❌ No         | ✅ Yes              | ❌ No           | Not responsive to interruption |
| `lockInterruptibly()`| ✅ Yes        | ✅ Yes              | ❌ No           | Responsive to interruption     |
| `tryLock()`          | ✅ Yes        | ❌ No (with timeout)| ✅ Yes          | Good for avoiding deadlocks    |

---

## 🧠 Best Practice

> Prefer `lockInterruptibly()` or `tryLock()` in **responsive, interruption-sensitive, or deadlock-prone** systems.



