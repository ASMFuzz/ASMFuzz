@@ -316,7 +316,8 @@ public HotSpotCompiledCode finish(HotSpotResolvedJavaMethod method) {
         Site[] finishedSites = sites.toArray(new Site[0]);
         byte[] finishedData = data.finish();
         DataPatch[] finishedDataPatches = dataPatches.toArray(new DataPatch[0]);
-        return new HotSpotCompiledNmethod(method.getName(), finishedCode, finishedCode.length, finishedSites, new Assumption[0], new ResolvedJavaMethod[]{method}, new Comment[0], finishedData, 16,
+        int dataSectionAlignment = 8; // CodeBuffer::SECT_CONSTS code section alignment
+        return new HotSpotCompiledNmethod(method.getName(), finishedCode, finishedCode.length, finishedSites, new Assumption[0], new ResolvedJavaMethod[]{method}, new Comment[0], finishedData, dataSectionAlignment,
                         finishedDataPatches, false, frameSize, deoptRescue, method, 0, id, 0L, false);
     }
 