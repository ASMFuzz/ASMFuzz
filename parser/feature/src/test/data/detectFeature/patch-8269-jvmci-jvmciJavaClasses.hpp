@@ -333,15 +333,6 @@
     objectarray_field(HotSpotStackFrameReference, locals, "[Ljava/lang/Object;")                              \
     primarray_field(HotSpotStackFrameReference, localIsVirtual, "[Z")                                         \
   end_class                                                                                                   \
-  start_class(HotSpotMetaData, jdk_vm_ci_hotspot_HotSpotMetaData)                                             \
-    primarray_field(HotSpotMetaData, pcDescBytes, "[B")                                                       \
-    primarray_field(HotSpotMetaData, scopesDescBytes, "[B")                                                   \
-    primarray_field(HotSpotMetaData, relocBytes, "[B")                                                        \
-    primarray_field(HotSpotMetaData, exceptionBytes, "[B")                                                    \
-    primarray_field(HotSpotMetaData, implicitExceptionBytes, "[B")                                            \
-    primarray_field(HotSpotMetaData, oopMaps, "[B")                                                           \
-    object_field(HotSpotMetaData, metadata, "[Ljava/lang/Object;")                                            \
-  end_class                                                                                                   \
   start_class(HotSpotConstantPool, jdk_vm_ci_hotspot_HotSpotConstantPool)                                     \
     long_field(HotSpotConstantPool, metadataHandle)                                                           \
   end_class                                                                                                   \