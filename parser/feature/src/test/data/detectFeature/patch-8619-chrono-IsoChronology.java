@@ -123,7 +123,8 @@
  *
  * @since 1.8
  */
-public final class IsoChronology extends AbstractChronology implements Serializable {
+public final class IsoChronology extends AbstractChronology implements Serializable,
+    FooChronology {
 
     /**
      * Singleton instance of the ISO chronology.