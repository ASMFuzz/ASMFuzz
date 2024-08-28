@@ -310,7 +310,7 @@ private Class<?> generateInnerClass() throws LambdaConversionException {
             interfaceNames = new String[]{interfaceName};
         } else {
             // Assure no duplicate interfaces (ClassFormatError)
-            Set<String> itfs = new LinkedHashSet<>(altInterfaces.length + 1);
+            Set<String> itfs = LinkedHashSet.newLinkedHashSet(altInterfaces.length + 1);
             itfs.add(interfaceName);
             for (Class<?> i : altInterfaces) {
                 itfs.add(i.getName().replace('.', '/'));