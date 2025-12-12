# 🖥️ Context Switching 🔄

CPU switches from one thread to another, saving the current thread’s state and loading the next thread’s state.  

### ⏰ When it happens

- ⚡ `More threads than CPU cores.`  
- 📌 `Example: CPU has 8 cores, but 100 threads are assigned.`  

### ⚙️ How it works

- 🏃 `CPU runs threads up to its core capacity.`  
- ⏸️ `When a thread waits, sleeps, or finishes, CPU switches to another thread.`  
- 💾 `CPU saves the old thread’s state and loads the new thread’s state.`  

### 📊 Impact

- ⏳ `Each switch takes extra time → slows down task completion.`  
- 🔋 `Uses extra CPU resources → can reduce overall performance if too many threads.`  

### ✅ Advantages

- 💻 `Allows multitasking even with fewer CPU cores.`  
- ⏱️ `Ensures all threads get CPU time.`  
- 🛠️ `Helps in handling I/O-bound tasks efficiently.`  

### ❌ Disadvantages

- 🐢 `Frequent switching adds overhead → slows down execution.`  
- 🧠 `Uses extra CPU memory and resources.`  
- ⚠️ `Too many threads → CPU overload → poor performance.`  
