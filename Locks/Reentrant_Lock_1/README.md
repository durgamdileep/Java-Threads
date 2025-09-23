
## 🔑 What is a ReentrantLock?

ReentrantLock is part of java.util.concurrent.locks. It’s a **more flexible and powerful alternative to the synchronized keyword**.

**Reentrancy means the same thread can acquire the same lock multiple times without getting blocked or deadlocked.**

### 🔄 What Happens Internally: Step-by-Step (Based on the Code)

1. mainHouseKey(task) is called by a thread.
2. reentrantLock.lock() is called → lock count = 1
3. Inside mainHouseKey(), bedRoom(task) is called.
4. reentrantLock.lock() is called again by the same thread inside bedRoom() → lock count = 2
5. bedRoom() finishes and calls reentrantLock.unlock() → lock count = 1
6. Control returns to mainHouseKey(), which finally calls reentrantLock.unlock() → lock count = 0
7. The lock is now fully released, allowing other threads to acquire it.



### ⚙️ Internally in Java:

1. ReentrantLock keeps a hold count.
2. Every time the same thread calls lock(), the count increases.
3. Every unlock() decreases the count.
4. Only when the count reaches zero, the lock is fully released.