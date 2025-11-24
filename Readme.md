# Java Concurrency Concepts

## 🔍 Visibility

- 👀 When one thread updates a shared variable, visibility ensures that other threads see the updated value.
- ⚡ The `volatile` keyword in Java provides visibility: writes by one thread become immediately visible to others.

---

## 🔒 Mutual Exclusion

- 🛡️ Mutual exclusion ensures that only one thread at a time can execute a specific block of code or update a shared resource.
- ⚠️ This is required to avoid race conditions.

---

## 🟡 volatile

- 🎯 Purpose: Ensure visibility of changes across threads.
- ✅ Guarantees:
  - 🔄 Latest value of a variable is always read from main memory.
  - ⚡ Atomic only for single reads/writes, not for compound operations.
- 📝 Use case:
  - 🚩 Flags, status variables, single assignment variables.
- ⚠️ Limitations:
  - 🚫 No mutual exclusion → multiple threads can still modify at the same time.
  - ❌ Not suitable for operations like `i++`, `count += 1`.

``` java
volatile boolean flag = true;
flag = false;    // Safe write
boolean x = flag; // Safe read

```

---

## 🟢 synchronized

- 🎯 Purpose: Ensure mutual exclusion + visibility.
- ✅ Guarantees:
  - 🔒 Only one thread at a time can execute the synchronized block/method.
  - 🔄 Threads always see latest values from main memory.
  - 🛡️ Safe for both read and write, including compound operations.
- 📝 Use case:
  - 📊 Updating shared counters, lists, or any shared resource safely.
``` java
synchronized(this) {
    count++;  // Safe compound operation
}

```
---

## ⚡ Atomic Classes (`java.util.concurrent.atomic`)

- 🎯 Purpose: Provide lock-free atomic operations.
- ✅ Guarantees:
  - ⚡ Operations like increment, compare-and-set (CAS) are all-or-nothing.
  - 🏎️ High performance compared to synchronized because no locking.
- 📝 Examples: `AtomicInteger`, `AtomicBoolean`, `AtomicReference`
- 📝 Use case:
  - 🔢 Counters, flags, or references updated concurrently without locks.

``` java
 AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet(); // Atomic, thread-safe, no locks

```

## ⚡ How Atomic Classes Work

- 🔄 Atomic classes perform atomic operations using CAS (Compare-And-Swap).
- ⚡ This means a single operation (like `incrementAndGet`) happens all at once — no other thread can see it halfway, but there’s no explicit lock.
- 👥 Multiple threads can access the variable simultaneously, but each atomic operation is safe.

### 📝 Key point: Atomic = atomicity of operations + visibility, not traditional mutual exclusion like `synchronized`.

