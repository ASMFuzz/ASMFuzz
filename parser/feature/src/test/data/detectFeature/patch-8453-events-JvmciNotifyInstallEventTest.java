@@ -116,10 +116,11 @@ private void runTest() {
         }
         HotSpotResolvedJavaMethod method = CTVMUtilities
                 .getResolvedMethod(SimpleClass.class, testMethod);
+        int dataSectionAlignment = 8; // CodeBuffer::SECT_CONSTS code section alignment
         HotSpotCompiledCode compiledCode = new HotSpotCompiledNmethod(METHOD_NAME,
                 new byte[0], 0, new Site[0], new Assumption[0],
                 new ResolvedJavaMethod[]{method}, new Comment[0], new byte[0],
-                16, new DataPatch[0], false, 0, null,
+                dataSectionAlignment, new DataPatch[0], false, 0, null,
                 method, 0, 1, 0L, false);
         codeCache.installCode(method, compiledCode, /* installedCode = */ null,
                 /* speculationLog = */ null, /* isDefault = */ false);