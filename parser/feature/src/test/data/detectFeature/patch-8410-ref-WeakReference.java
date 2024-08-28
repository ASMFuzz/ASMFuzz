@@ -40,6 +40,7 @@
  * weakly-reachable objects to be finalizable.  At the same time or at some
  * later time it will enqueue those newly-cleared weak references that are
  * registered with reference queues.
+ * @param<T> the type of the referent
  *
  * @author   Mark Reinhold
  * @since    1.2