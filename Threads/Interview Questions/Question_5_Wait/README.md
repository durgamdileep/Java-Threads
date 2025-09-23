### Simulation Explanation:

1. Thread-1 calls wait() and enters the waiting state, releasing the lock. 
2. Thread-2 starts and sleeps for 2 seconds to simulate delay. 
3. After 2 seconds, Thread-2 calls notify(), waking up Thread-1. 
4. Thread-1 resumes execution after wait() and prints "Thread-1 resumed after notify." 

### No time-specific waiting

wait() (without arguments) causes **the thread to wait indefinitely**.

#### It will only resume if:
   *   Another thread calls notify() or notifyAll()
   *   Or it is interrupted

### Avoid thread leaks by ensuring threads don't get stuck in WAITING or BLOCKED states🧹
Example :  A thread waiting indefinitely for a signal can cause a leak. Use timeouts to prevent this while acquiring locks or waiting on conditions.


### Timed_Waiting

wait(3000) means the thread will wait up to 3 seconds.
* If **no notification is received**, it will move to the runnable state after 3 seconds and try to reacquire the lock.
* If **a notification is received before 3 seconds**, it will move to the runnable state immediately (without waiting the full 3 seconds) and try to reacquire the lock.