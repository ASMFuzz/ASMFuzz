@@ -37,13 +37,6 @@
 @StackTrace(false)
 public final class ActiveSettingEvent extends AbstractJDKEvent {
 
-    public static final ThreadLocal<ActiveSettingEvent> EVENT = new ThreadLocal<ActiveSettingEvent>() {
-        @Override
-        protected ActiveSettingEvent initialValue() {
-            return new ActiveSettingEvent();
-        }
-    };
-
     @Label("Event Id")
     public long id;
 