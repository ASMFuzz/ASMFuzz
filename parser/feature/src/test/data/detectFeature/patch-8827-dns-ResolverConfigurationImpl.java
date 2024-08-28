@@ -25,6 +25,8 @@
 
 package sun.net.dns;
 
+import jdk.internal.misc.InnocuousThread;
+
 import java.util.ArrayList;
 import java.util.List;
 import java.util.concurrent.TimeUnit;
@@ -37,7 +39,7 @@ public final class ResolverConfigurationImpl
     extends ResolverConfiguration
 {
     // Lock held whilst loading configuration or checking
-    private static Object lock = new Object();
+    private static final Object lock = new Object();
 
     // Resolver options
     private final Options opts;
@@ -169,7 +171,8 @@ public Options options() {
 
     // --- Address Change Listener
 
-    static class AddressChangeListener extends Thread {
+    static class AddressChangeListener implements Runnable {
+        @Override
         public void run() {
             for (;;) {
                 // wait for configuration to change
@@ -196,9 +199,11 @@ public void run() {
         init0();
 
         // start the address listener thread
-        AddressChangeListener thr = new AddressChangeListener();
-        thr.setDaemon(true);
-        thr.start();
+        String name = "Jndi-Dns-address-change-listener";
+        Thread addrChangeListener = InnocuousThread.newSystemThread(name,
+                new AddressChangeListener());
+        addrChangeListener.setDaemon(true);
+        addrChangeListener.start();
     }
 }
 