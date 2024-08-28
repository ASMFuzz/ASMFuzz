@@ -632,7 +632,7 @@ public static synchronized MBeanServer getPlatformMBeanServer() {
     // using newPlatformMXBeanProxy(mbs, on, LoggingMXBean.class)
     // even though the underlying MXBean no longer implements
     // java.util.logging.LoggingMXBean.
-    // Altough java.util.logging.LoggingMXBean is deprecated, an application
+    // Although java.util.logging.LoggingMXBean is deprecated, an application
     // that uses newPlatformMXBeanProxy(mbs, on, LoggingMXBean.class) will
     // continue to work.
     //