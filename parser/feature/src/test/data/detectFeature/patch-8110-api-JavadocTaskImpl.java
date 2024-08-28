@@ -43,11 +43,6 @@
 /**
  * Provides access to functionality specific to the JDK documentation tool,
  * javadoc.
- *
- * <p><b>This is NOT part of any supported API.
- * If you write code that depends on this, you do so at your own
- * risk.  This code and its internal interfaces are subject to change
- * or deletion without notice.</b></p>
  */
 public class JavadocTaskImpl implements DocumentationTask {
     private final AtomicBoolean used = new AtomicBoolean();