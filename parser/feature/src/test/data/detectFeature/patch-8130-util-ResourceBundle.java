@@ -2438,7 +2438,7 @@ protected Set<String> handleKeySet() {
      * import static java.util.ResourceBundle.Control.*;
      * ...
      * ResourceBundle bundle =
-     *   ResourceBundle.getBundle("MyResources", new Locale("fr", "CH"),
+     *   ResourceBundle.getBundle("MyResources", Locale.forLanguageTag("fr-CH"),
      *                            ResourceBundle.Control.getControl(FORMAT_PROPERTIES));
      * </pre>
      *