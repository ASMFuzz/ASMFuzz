@@ -47,7 +47,7 @@
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicBoolean;
 import java.util.concurrent.atomic.AtomicReference;
-
+import java.util.stream.Collectors;
 import jdk.test.lib.Platform;
 
 import com.sun.management.UnixOperatingSystemMXBean;
@@ -377,6 +377,44 @@ public static long getProcessHandleCount() {
         }
     }
 
+    /**
+     * Patches a part of a file.
+     *
+     * @param path the file
+     * @param fromLine the first line to patch. This is the number you see in an editor, 1-based, inclusive.
+     * @param toLine the last line to patch. This is the number you see in an editor, inclusive.
+     *               Set {@code toLine} to {@code fromLine - 1} if you only want to insert lines.
+     * @param from lines to remove, used to ensure the correct lines are removed. Can be multiple lines or empty.
+     *            It's compared to existing lines with all lines trimmed and no new lines at both ends. Ignored if null.
+     * @param to the newly added lines, can be multiple lines or empty. New line at end is optional. Cannot be null.
+     * @throws IOException if there's an I/O error or {@code from} does not match the existing lines
+     * @throws IndexOutOfBoundsException if {@code fromLine} or {@code toLine} is invalid
+     */
+    public static void patch(Path path, int fromLine, int toLine, String from, String to) throws IOException {
+        var lines = Files.readAllLines(path);
+        // The next line does a from/to as well
+        var subList = lines.subList(fromLine - 1, toLine);
+        if (from != null) {
+            // Each line is trimmed so caller needs not care about indentation.
+            // Caller also needs not care about new lines on both ends.
+            // New lines inside are preserved.
+            String actuallyRemoved = subList.stream()
+                            .map(String::trim)
+                            .collect(Collectors.joining("\n")).trim();
+            String wantToRemove = from.lines()
+                            .map(String::trim)
+                            .collect(Collectors.joining("\n")).trim();
+            if (!actuallyRemoved.equals(wantToRemove)) {
+                throw new IOException("Removed not the same: ["
+                        + String.join("\\n", subList) + "] and ["
+                        + from.replaceAll("\\n", "\\\\n") + "]");
+            }
+        }
+        subList.clear();
+        lines.addAll(fromLine - 1, to.lines().toList());
+        Files.write(path, lines);
+    }
+
     private static native long getWinProcessHandleCount();
 
     // Possible command locations and arguments