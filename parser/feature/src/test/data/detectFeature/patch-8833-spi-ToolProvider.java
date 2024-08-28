@@ -50,6 +50,14 @@
  * arguments that could be provided to the tool when invoking the tool
  * from the command line.
  *
+ * @apiNote
+ * It is recommended that tools implementing this interface are either
+ * reusable and reentrant, or should clearly document any limitations and
+ * restrictions. In this context, reusable means that any one instance of
+ * a tool may be the target of multiple {@code run} method invocations,
+ * and reentrant means that multiple invocations of {@code run} may occur
+ * concurrently.
+ *
  * @since 9
  */
 public interface ToolProvider {