@@ -183,6 +183,9 @@
   do_klass(vector_VectorMask_klass,                     jdk_internal_vm_vector_VectorMask                     ) \
   do_klass(vector_VectorShuffle_klass,                  jdk_internal_vm_vector_VectorShuffle                  ) \
                                                                                                                 \
+  /* GC support */                                                                                              \
+  do_klass(FillerObject_klass,                          jdk_internal_vm_FillerObject                          ) \
+                                                                                                                \
   /*end*/
 
 #endif // SHARE_CLASSFILE_VMCLASSMACROS_HPP