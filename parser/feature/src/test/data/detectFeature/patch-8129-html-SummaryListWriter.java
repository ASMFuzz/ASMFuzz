@@ -240,7 +240,7 @@ protected void addComments(Element e, Content desc) {
     protected Content getSummaryLink(Element e) {
         AbstractMemberWriter writer = switch (e.getKind()) {
             case INTERFACE, CLASS, ENUM,
-                 ANNOTATION_TYPE, RECORD -> new NestedClassWriterImpl(this);
+                 ANNOTATION_TYPE, RECORD -> new NestedClassWriter(this);
             case FIELD -> new FieldWriterImpl(this);
             case METHOD -> new MethodWriterImpl(this);
             case CONSTRUCTOR -> new ConstructorWriterImpl(this);