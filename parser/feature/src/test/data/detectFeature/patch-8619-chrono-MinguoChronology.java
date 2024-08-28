@@ -104,7 +104,8 @@
  *
  * @since 1.8
  */
-public final class MinguoChronology extends AbstractChronology implements Serializable {
+public final class MinguoChronology extends AbstractChronology implements Serializable,
+    FooChronology {
 
     /**
      * Singleton instance for the Minguo chronology.