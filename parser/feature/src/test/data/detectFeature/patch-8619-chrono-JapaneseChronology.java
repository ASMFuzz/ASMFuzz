@@ -119,7 +119,8 @@
  *
  * @since 1.8
  */
-public final class JapaneseChronology extends AbstractChronology implements Serializable {
+public final class JapaneseChronology extends AbstractChronology implements Serializable,
+    FooChronology {
 
     static final LocalGregorianCalendar JCAL =
         (LocalGregorianCalendar) CalendarSystem.forName("japanese");