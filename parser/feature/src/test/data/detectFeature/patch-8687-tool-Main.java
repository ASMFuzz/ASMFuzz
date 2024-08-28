@@ -25,9 +25,9 @@
 
 package jdk.jfr.internal.tool;
 
+import java.util.ArrayDeque;
 import java.util.Arrays;
 import java.util.Deque;
-import java.util.LinkedList;
 
 /**
  * Launcher class for the JDK_HOME\bin\jfr tool
@@ -40,7 +40,7 @@ public final class Main {
     private static final int EXIT_WRONG_ARGUMENTS = 2;
 
     public static void main(String... args) {
-        Deque<String> argList = new LinkedList<>(Arrays.asList(args));
+        Deque<String> argList = new ArrayDeque<>(Arrays.asList(args));
         if (argList.isEmpty()) {
             System.out.println(Command.title);
             System.out.println();