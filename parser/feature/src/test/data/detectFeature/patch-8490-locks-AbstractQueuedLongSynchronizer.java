@@ -1156,7 +1156,9 @@ private long enableWait(ConditionNode node) {
          */
         private boolean canReacquire(ConditionNode node) {
             // check links, not status to avoid enqueue race
-            return node != null && node.prev != null && isEnqueued(node);
+            Node p; // traverse unless known to be bidirectionally linked
+            return node != null && (p = node.prev) != null &&
+                (p.next == node || isEnqueued(node));
         }
 
         /**