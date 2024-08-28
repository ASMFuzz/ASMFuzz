@@ -374,10 +374,14 @@ public void run() {
 
                     /* process the selected list now  */
                     Set<SelectionKey> selected = selector.selectedKeys();
-                    Iterator<SelectionKey> iter = selected.iterator();
-                    while (iter.hasNext()) {
-                        SelectionKey key = iter.next();
-                        iter.remove ();
+                    // create a copy of the selected keys so that we can iterate over it
+                    // and at the same time not worry about the underlying Set being
+                    // modified (leading to ConcurrentModificationException) due to
+                    // any subsequent select operations that we invoke on the
+                    // selector (in this same thread).
+                    for (final SelectionKey key : selected.toArray(SelectionKey[]::new)) {
+                        // remove the key from the original selected keys (live) Set
+                        selected.remove(key);
                         if (key.equals (listenerKey)) {
                             if (terminating) {
                                 continue;