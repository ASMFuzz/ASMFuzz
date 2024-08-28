@@ -1047,14 +1047,7 @@ void SystemDictionaryShared::record_linking_constraint(Symbol* name, InstanceKla
     return;
   }
 
-  if (DumpSharedSpaces && !is_builtin(klass)) {
-    // During static dump, unregistered classes (those intended for
-    // custom loaders) are loaded by the boot loader. Need to
-    // exclude these for the same reason as above.
-    // This should be fixed by JDK-8261941.
-    return;
-  }
-
+  assert(is_builtin(klass), "must be");
   assert(klass_loader != NULL, "should not be called for boot loader");
   assert(loader1 != loader2, "must be");
 