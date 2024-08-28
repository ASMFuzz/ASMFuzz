@@ -122,7 +122,12 @@ public enum Source {
     /**
       * 19, tbd
       */
-    JDK19("19");
+    JDK19("19"),
+
+    /**
+      * 20, tbd
+      */
+    JDK20("20");
 
     private static final Context.Key<Source> sourceKey = new Context.Key<>();
 
@@ -174,6 +179,7 @@ public boolean isSupported() {
 
     public Target requiredTarget() {
         return switch(this) {
+        case JDK20  -> Target.JDK1_20;
         case JDK19  -> Target.JDK1_19;
         case JDK18  -> Target.JDK1_18;
         case JDK17  -> Target.JDK1_17;
@@ -322,6 +328,7 @@ public static SourceVersion toSourceVersion(Source source) {
         case JDK17  -> RELEASE_17;
         case JDK18  -> RELEASE_18;
         case JDK19  -> RELEASE_19;
+        case JDK20  -> RELEASE_20;
         default     -> null;
         };
     }