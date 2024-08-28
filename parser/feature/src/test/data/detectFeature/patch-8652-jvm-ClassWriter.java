@@ -825,7 +825,7 @@ void writeInnerClasses() {
         databuf.appendChar(poolWriter.innerClasses.size());
         for (ClassSymbol inner : poolWriter.innerClasses) {
             inner.markAbstractIfNeeded(types);
-            char flags = (char) adjustFlags(inner.flags_field);
+            int flags = adjustFlags(inner.flags_field);
             if ((flags & INTERFACE) != 0) flags |= ABSTRACT; // Interfaces are always ABSTRACT
             flags &= ~STRICTFP; //inner classes should not have the strictfp flag set.
             if (dumpInnerClassModifiers) {