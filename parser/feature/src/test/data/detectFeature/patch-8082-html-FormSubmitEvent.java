@@ -35,7 +35,7 @@
  * @author    Denis Sharypov
  */
 @SuppressWarnings("serial") // Superclass is not serializable across versions
-public class FormSubmitEvent extends HTMLFrameHyperlinkEvent {
+public final class FormSubmitEvent extends HTMLFrameHyperlinkEvent {
 
     /**
      * Represents an HTML form method type.