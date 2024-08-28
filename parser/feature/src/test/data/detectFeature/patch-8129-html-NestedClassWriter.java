@@ -42,14 +42,14 @@
 /**
  * Writes nested class documentation in HTML format.
  */
-public class NestedClassWriterImpl extends AbstractMemberWriter
+public class NestedClassWriter extends AbstractMemberWriter
     implements MemberSummaryWriter {
 
-    public NestedClassWriterImpl(SubWriterHolderWriter writer, TypeElement typeElement) {
+    public NestedClassWriter(SubWriterHolderWriter writer, TypeElement typeElement) {
         super(writer, typeElement);
     }
 
-    public NestedClassWriterImpl(SubWriterHolderWriter writer) {
+    public NestedClassWriter(SubWriterHolderWriter writer) {
         super(writer);
     }
 