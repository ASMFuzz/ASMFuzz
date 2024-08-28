@@ -27,6 +27,7 @@
 
 import java.io.IOException;
 import java.io.PrintStream;
+import java.nio.file.Files;
 import java.nio.file.Path;
 import java.util.ArrayList;
 import java.util.Deque;
@@ -132,7 +133,7 @@ public void execute(Deque<String> options) throws UserSyntaxException, UserDataE
             input = last;
             output = dir == null ? Path.of(t) : dir.resolve(t);
         }
-        ensureFileDoesNotExist(output);
+        ensureUsableOutput(input, output);
 
         List<Predicate<RecordedEvent>> filters = new ArrayList<>();
         int optionCount = options.size();
@@ -191,4 +192,25 @@ public void execute(Deque<String> options) throws UserSyntaxException, UserDataE
         println("Scrubbed recording file written to:");
         println(output.toAbsolutePath().toString());
     }
+
+    private void ensureUsableOutput(Path input, Path output) throws UserSyntaxException, UserDataException {
+        if (!Files.exists(output)) {
+            return;
+        }
+        if (!Files.exists(input)) {
+            return; // Will fail later when reading file
+        }
+        try {
+            if (Files.isSameFile(input, output)) {
+                throw new UserSyntaxException("output file can't be same as input file " + input.toAbsolutePath());
+            }
+        } catch (IOException e) {
+            throw new UserDataException("could not access " + input.toAbsolutePath() + " or " + output.toAbsolutePath() + ". " + e.getMessage());
+        }
+        try {
+            Files.delete(output);
+        } catch (IOException e) {
+            throw new UserDataException("could not delete existing output file " + output.toAbsolutePath() + ". " + e.getMessage());
+        }
+    }
 }