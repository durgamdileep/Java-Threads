
### tryLock()
   – Immediate response

### tryLock(long timeout, TimeUnit unit)
   – Wait for some time.

Let’s say two users, virat and abd, try to withdraw money at the same time.

#### Explanation:

1. virat acquires the lock immediately in machine1().
2. Inside the try block, you add Thread.sleep(3000) — simulating ATM usage for 3 seconds.
3. Meanwhile, abd tries to get the lock in machine1(), but fails.
4. He goes to machine2() and waits for 2 seconds (using tryLock(2, TimeUnit.SECONDS)).
5. But since virat is still holding the lock (3s > 2s), abd also fails to acquire the lock and leaves without withdrawing.