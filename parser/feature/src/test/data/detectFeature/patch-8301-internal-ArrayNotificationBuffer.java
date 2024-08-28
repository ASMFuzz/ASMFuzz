@@ -114,9 +114,7 @@ public class ArrayNotificationBuffer implements NotificationBuffer {
     // FACTORY STUFF, INCLUDING SHARING
 
     private static final Object globalLock = new Object();
-    private static final
-        HashMap<MBeanServer,ArrayNotificationBuffer> mbsToBuffer =
-        new HashMap<MBeanServer,ArrayNotificationBuffer>(1);
+    private static final HashMap<MBeanServer,ArrayNotificationBuffer> mbsToBuffer = HashMap.newHashMap(1);
     private final Collection<ShareBuffer> sharers = new HashSet<ShareBuffer>(1);
 
     public static NotificationBuffer getNotificationBuffer(