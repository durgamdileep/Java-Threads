### ⚖️ Fairness: Lock Ordering
By default, ReentrantLock is non-fair. 
This means any thread can cut the line if the lock becomes available.

* **Fair lock** = Queue at a ticket counter. First come, first serve.
* **Unfair lock** = Some people jump the line (performance is better, but may be unfair).