
### Simulation Explanation: 

1. The main thread prints "Thread is going to sleep...". 
2. It pauses execution for 3 seconds (sleep(3000)). 
3. After 3 seconds, execution resumes normally, printing "Thread woke up after sleeping." 
4. sleep() does NOT release any locks, meaning other threads can't access synchronized resources during sleep. 
