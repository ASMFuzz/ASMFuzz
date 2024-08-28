@@ -81,7 +81,7 @@ public static void main(String argv[]) throws Exception {
 
         // Prepare to wait for FOS, FD, Cleanup to be reclaimed
         ReferenceQueue<Object> queue = new ReferenceQueue<>();
-        HashSet<Reference<?>> pending = new HashSet<>(3);
+        HashSet<Reference<?>> pending = HashSet.newHashSet(3);
         pending.add(new WeakReference<>(cleanup, queue));
         pending.add(new WeakReference<>(raf, queue));
         pending.add(new WeakReference<>(fd, queue));