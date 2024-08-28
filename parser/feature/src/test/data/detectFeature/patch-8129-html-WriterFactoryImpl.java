@@ -141,7 +141,7 @@ public MemberSummaryWriter getMemberSummaryWriter(ClassWriter classWriter,
             case PROPERTIES:
                 return getPropertyWriter(classWriter);
             case NESTED_CLASSES:
-                return new NestedClassWriterImpl((SubWriterHolderWriter)
+                return new NestedClassWriter((SubWriterHolderWriter)
                     classWriter, classWriter.getTypeElement());
             case METHODS:
                 return getMethodWriter(classWriter);