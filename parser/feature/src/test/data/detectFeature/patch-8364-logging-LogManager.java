@@ -159,7 +159,7 @@ public class LogManager {
     // be able to see a partially constructed 'props' object.
     // (seeing a partially constructed 'props' object can result in
     // NPE being thrown in Hashtable.get(), because it leaves the door
-    // open for props.getProperties() to be called before the construcor
+    // open for props.getProperties() to be called before the constructor
     // of Hashtable is actually completed).
     private volatile Properties props = new Properties();
     private static final Level defaultLevel = Level.INFO;