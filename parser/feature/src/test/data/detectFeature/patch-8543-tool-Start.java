@@ -209,7 +209,7 @@ private void showVersion(String labelKey, String value) {
     }
 
     private void showToolOptions(ToolOption.Kind kind) {
-        Comparator<ToolOption> comp = new Comparator<ToolOption>() {
+        var comp = new Comparator<ToolOption>() {
             final Collator collator = Collator.getInstance(Locale.US);
             { collator.setStrength(Collator.PRIMARY); }
 
@@ -250,7 +250,7 @@ private void showDocletOptions(Option.Kind kind) {
         }
         showLinesUsingKey("main.doclet.usage.header", name);
 
-        Comparator<Doclet.Option> comp = new Comparator<Doclet.Option>() {
+        var comp = new Comparator<Doclet.Option>() {
             final Collator collator = Collator.getInstance(Locale.US);
             { collator.setStrength(Collator.PRIMARY); }
 