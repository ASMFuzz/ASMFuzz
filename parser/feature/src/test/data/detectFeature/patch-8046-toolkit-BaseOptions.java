@@ -40,7 +40,6 @@
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.Calendar;
-import java.util.Collections;
 import java.util.HashSet;
 import java.util.LinkedHashSet;
 import java.util.List;
@@ -1028,7 +1027,7 @@ public boolean showVersion() {
      * Arguments for command line option {@code --since}.
      */
     public List<String> since() {
-        return Collections.unmodifiableList(since);
+        return List.copyOf(since);
     }
 
     /**