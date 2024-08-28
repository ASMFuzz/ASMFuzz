@@ -429,10 +429,10 @@ public final void wait(long timeoutMillis) throws InterruptedException {
      * is not satisfied. See the example below.
      * <p>
      * For more information on this topic, see section 14.2,
-     * "Condition Queues," in Brian Goetz and others' <em>Java Concurrency
-     * in Practice</em> (Addison-Wesley, 2006) or Item 69 in Joshua
-     * Bloch's <em>Effective Java, Second Edition</em> (Addison-Wesley,
-     * 2008).
+     * "Condition Queues," in Brian Goetz and others' <cite>Java Concurrency
+     * in Practice</cite> (Addison-Wesley, 2006) or Item 81 in Joshua
+     * Bloch's <cite>Effective Java, Third Edition</cite> (Addison-Wesley,
+     * 2018).
      * <p>
      * If the current thread is {@linkplain java.lang.Thread#interrupt() interrupted}
      * by any thread before or while it is waiting, then an {@code InterruptedException}