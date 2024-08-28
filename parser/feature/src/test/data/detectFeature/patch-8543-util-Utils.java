@@ -1235,18 +1235,17 @@ public String replaceTabs(String text) {
         for (int i = 0; i < textLength; i++) {
             char ch = text.charAt(i);
             switch (ch) {
-                case '\n': case '\r':
-                    lineLength = 0;
-                    break;
-                case '\t':
+                case '\n', '\r' -> lineLength = 0;
+
+                case '\t' -> {
                     result.append(text, pos, i);
                     int spaceCount = tabLength - lineLength % tabLength;
                     result.append(whitespace, 0, spaceCount);
                     lineLength += spaceCount;
                     pos = i + 1;
-                    break;
-                default:
-                    lineLength++;
+                }
+
+                default -> lineLength++;
             }
         }
         result.append(text, pos, textLength);
@@ -1261,18 +1260,18 @@ public CharSequence normalizeNewlines(CharSequence text) {
         for (int i = 0; i < textLength; i++) {
             char ch = text.charAt(i);
             switch (ch) {
-                case '\n':
+                case '\n' -> {
                     sb.append(text, pos, i);
                     sb.append(NL);
                     pos = i + 1;
-                    break;
-                case '\r':
+                }
+                case '\r' -> {
                     sb.append(text, pos, i);
                     sb.append(NL);
                     if (i + 1 < textLength && text.charAt(i + 1) == '\n')
                         i++;
                     pos = i + 1;
-                    break;
+                }
             }
         }
         sb.append(text, pos, textLength);
@@ -1493,28 +1492,26 @@ public String getHTMLTitle(Element element) {
         loop:
         for (DocTree dt : preamble) {
             switch (dt.getKind()) {
-                case START_ELEMENT:
-                    StartElementTree nodeStart = (StartElementTree)dt;
+                case START_ELEMENT -> {
+                    StartElementTree nodeStart = (StartElementTree) dt;
                     if (Utils.toLowerCase(nodeStart.getName().toString()).equals("title")) {
                         titleFound = true;
                     }
-                    break;
-
-                case END_ELEMENT:
-                    EndElementTree nodeEnd = (EndElementTree)dt;
+                }
+                case END_ELEMENT -> {
+                    EndElementTree nodeEnd = (EndElementTree) dt;
                     if (Utils.toLowerCase(nodeEnd.getName().toString()).equals("title")) {
                         break loop;
                     }
-                    break;
-
-                case TEXT:
-                    TextTree nodeText = (TextTree)dt;
+                }
+                case TEXT -> {
+                    TextTree nodeText = (TextTree) dt;
                     if (titleFound)
                         sb.append(nodeText.getBody());
-                    break;
-
-                default:
-                    // do nothing
+                }
+                default -> {
+                }
+                // do nothing
             }
         }
         return sb.toString().trim();
@@ -1528,8 +1525,9 @@ private DocCollator(Locale locale, int strength) {
             instance = createCollator(locale);
             instance.setStrength(strength);
 
-            keys = new LinkedHashMap<String, CollationKey>(MAX_SIZE + 1, 0.75f, true) {
+            keys = new LinkedHashMap<>(MAX_SIZE + 1, 0.75f, true) {
                 private static final long serialVersionUID = 1L;
+
                 @Override
                 protected boolean removeEldestEntry(Entry<String, CollationKey> eldest) {
                     return size() > MAX_SIZE;
@@ -1916,7 +1914,7 @@ private <T extends Element> List<T> getItems0(Element e, boolean all, Predicate<
 
     public boolean shouldDocument(Element e) {
         if (shouldDocumentVisitor == null) {
-            shouldDocumentVisitor = new SimpleElementVisitor14<Boolean, Void>() {
+            shouldDocumentVisitor = new SimpleElementVisitor14<>() {
                 private boolean hasSource(TypeElement e) {
                     return configuration.docEnv.getFileKind(e) ==
                             javax.tools.JavaFileObject.Kind.SOURCE;
@@ -1925,7 +1923,7 @@ private boolean hasSource(TypeElement e) {
                 // handle types
                 @Override
                 public Boolean visitType(TypeElement e, Void p) {
-                    // treat inner classes etc as members
+                    // treat inner classes etc. as members
                     if (e.getNestingKind().isNested()) {
                         return defaultAction(e, p);
                     }
@@ -2547,7 +2545,7 @@ public CommentHelper put(Element key, CommentHelper value) {
             return prev == null ? null : prev.get();
         }
 
-        public CommentHelper get(Object key) {
+        public CommentHelper get(Element key) {
             SoftReference<CommentHelper> value = map.get(key);
             return value == null ? null : value.get();
         }
@@ -2855,7 +2853,7 @@ public PreviewFlagProvider setPreviewFlagProvider(PreviewFlagProvider provider)
     }
 
     public interface PreviewFlagProvider {
-        public boolean isPreview(Element el);
+        boolean isPreview(Element el);
     }
 
 }