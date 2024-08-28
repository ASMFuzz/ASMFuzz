@@ -1211,8 +1211,10 @@ public MemorySegment map(MapMode mode, long offset, long size,
         Objects.requireNonNull(session, "Session is null");
         MemorySessionImpl sessionImpl = MemorySessionImpl.toSessionImpl(session);
         sessionImpl.checkValidStateSlow();
-        if (offset < 0) throw new IllegalArgumentException("Requested bytes offset must be >= 0.");
-        if (size < 0) throw new IllegalArgumentException("Requested bytes size must be >= 0.");
+        if (offset < 0)
+            throw new IllegalArgumentException("Requested bytes offset must be >= 0.");
+        if (size < 0)
+            throw new IllegalArgumentException("Requested bytes size must be >= 0.");
 
         boolean isSync = isSync(mode);
         int prot = toProt(mode);
@@ -1222,14 +1224,17 @@ public MemorySegment map(MapMode mode, long offset, long size,
             modes |= MAP_MEM_SEG_READ_ONLY;
         }
         if (unmapper != null) {
-            AbstractMemorySegmentImpl segment = new MappedMemorySegmentImpl(unmapper.address(), unmapper, size,
-                    modes, session);
-            sessionImpl.addOrCleanupIfFail(new MemorySessionImpl.ResourceList.ResourceCleanup() {
-                @Override
-                public void cleanup() {
-                    unmapper.unmap();
-                }
-            });
+            AbstractMemorySegmentImpl segment =
+                new MappedMemorySegmentImpl(unmapper.address(), unmapper, size,
+                                            modes, session);
+            MemorySessionImpl.ResourceList.ResourceCleanup resource =
+                new MemorySessionImpl.ResourceList.ResourceCleanup() {
+                    @Override
+                    public void cleanup() {
+                        unmapper.unmap();
+                    }
+                };
+            sessionImpl.addOrCleanupIfFail(resource);
             return segment;
         } else {
             return new MappedMemorySegmentImpl.EmptyMappedMemorySegmentImpl(modes, session);