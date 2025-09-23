### **Transaction Management**

* A transaction is a single unit of work that either completely succeeds or completely fails. Think of it as a "do all or do nothing" rule.
* Hibernate communicates with the database, and any operation that reads or writes data should be wrapped in a transaction. This ensures:
  1. Data consistency
  2. Rollback on failure
  3. Better performance through batching
  4. Safe concurrent access
### **Caching Support**

1. Built-in support for First-level cache (session-level)
2. Second-level cache (with providers like EhCache or Infinispan)
3. Query caching

####  **🔹 First-Level Cache (Session Cache)**

  📌 What it is:
  * Built-in and enabled by default in Hibernate.
  * It works at the Session level.
  * Data is cached only within the same session.

  ❌ Limitations:

  * Cache is only valid inside one session
  * When session is closed, the cache is gone
  * Not shared between different sessions or users

#### **🔹 Second-Level Cache (Shared Cache)**

  📌 What it is:

  * Optional and must be explicitly enabled.
  * Works across sessions, shared by the whole application.
  * Uses external providers like:
      * EhCache
      * Infinispan
      * Caffeine
      * Redis (via plugins)

### **🔄 Evicted from Cache?**

Eviction means removing an item (e.g. an entity) from the cache — either automatically or manually.

👉 The data stays in memory and is available for reuse until it is cleared from the cache.

#### **✅ Eviction Can Happen In Two Ways**

#### 1. Automatic Eviction (by Cache Policy)
Cache providers (like EhCache or Caffeine) use eviction policies to manage memory. 

These policies decide when to remove old/unused data.
* Common Eviction Triggers:
   * Time-based (TTL / TTI):
      * TTL (Time To Live): Remove item after X seconds from creation.
      * TTI (Time To Idle): Remove if not accessed for X seconds.
   * Size-based:
      * Evict least-used entries when cache size limit is exceeded (e.g., LRU = Least Recently Used).

#### 2. Manual Eviction (by Code)

You can explicitly tell Hibernate or the cache provider to evict cache entries.