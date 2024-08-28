@@ -84,7 +84,7 @@ public class ClassUseWriter extends SubWriterHolderWriter {
     final MethodWriterImpl methodSubWriter;
     final ConstructorWriterImpl constrSubWriter;
     final FieldWriterImpl fieldSubWriter;
-    final NestedClassWriterImpl classSubWriter;
+    final NestedClassWriter classSubWriter;
 
     /**
      * Constructor.
@@ -136,7 +136,7 @@ public ClassUseWriter(HtmlConfiguration configuration,
         constrSubWriter = new ConstructorWriterImpl(this);
         constrSubWriter.setFoundNonPubConstructor(true);
         fieldSubWriter = new FieldWriterImpl(this);
-        classSubWriter = new NestedClassWriterImpl(this);
+        classSubWriter = new NestedClassWriter(this);
     }
 
     /**