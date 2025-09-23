## In this output:

* 🏭 The producer prints a message when it produces an item.
* 🛑 If the buffer is full, the producer indicates that it is waiting.
* 🧑‍💻 The consumer prints a message when it consumes an item.
* ⏳ If the buffer is empty, the consumer indicates that it is waiting.
* 🔔 The calls to notifyAll() ensure that as soon as a change happens (an item is produced or consumed), the waiting threads are notified and re-check their conditions.

### 🧠 Explanation of the Code :

#### 1. 🗃️ Shared Buffer and Capacity:

* We use a Queue<Integer> (implemented via a LinkedList) to serve as the buffer.
* A constant CAPACITY limits the number of items in the buffer.


#### 2. 🔨 Producer (produce() Method):

* The producer enters a loop to continuously produce items.
* Inside a synchronized block (locking on the object created inside the ProducerConsumer clas), it checks if the buffer is full.
* If the buffer is full, the producer calls wait(), releasing the lock and suspending execution until notified.
* Once there’s room in the buffer, the producer adds a new integer value to the buffer, then calls notifyAll() to wake any waiting consumers.
* A short sleep simulates production time.

#### 3. 🧹 Consumer (consume() Method):

* The consumer similarly loops to continuously consume items.
* Inside a synchronized block, it waits while the buffer is empty, calling wait() to suspend execution.
* When an item is available, it retrieves (consumes) the item from the buffer and calls notifyAll() to signal the producer that space is now available.
* A sleep simulates consumption time.

#### 4. 🔄 Thread Communication:

* wait() and notifyAll() are both used inside synchronized blocks to ensure proper coordination between threads.
* notifyAll() is used so that all waiting threads (be they producers or consumers) get a chance to re-check their condition and continue if possible.


#### 5. 🚀 Main Method:

* Two threads are created—one for the producer and one for the consumer.
* They are started concurrently. As the threads run, you will see messages indicating when the producer or consumer is waiting, producing, or consuming items.