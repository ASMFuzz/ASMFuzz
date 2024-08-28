@@ -935,7 +935,7 @@ class methodHandle;
                                      "Ljava/lang/Object;"                                                                                      \
                                      "J"                                                                                                       \
                                      "Ljava/lang/Object;"                                                                                      \
-                                     "I"                                                                                                       \
+                                     "J"                                                                                                       \
                                      "Ljdk/internal/vm/vector/VectorSupport$VectorSpecies;"                                                    \
                                      "Ljdk/internal/vm/vector/VectorSupport$LoadOperation;)"                                                   \
                                      "Ljdk/internal/vm/vector/VectorSupport$VectorPayload;")                                                   \
@@ -950,7 +950,7 @@ class methodHandle;
                                             "J"                                                                                                \
                                             "Ljdk/internal/vm/vector/VectorSupport$VectorMask;"                                                \
                                             "Ljava/lang/Object;"                                                                               \
-                                            "I"                                                                                                \
+                                            "J"                                                                                                \
                                             "Ljdk/internal/vm/vector/VectorSupport$VectorSpecies;"                                             \
                                             "Ljdk/internal/vm/vector/VectorSupport$LoadVectorMaskedOperation;)"                                \
                                             "Ljdk/internal/vm/vector/VectorSupport$Vector;")                                                   \
@@ -962,8 +962,10 @@ class methodHandle;
                                       "I"                                                                                                      \
                                       "Ljava/lang/Object;"                                                                                     \
                                       "J"                                                                                                      \
-                                      "Ljdk/internal/vm/vector/VectorSupport$Vector;"                                                          \
-                                      "Ljava/lang/Object;ILjdk/internal/vm/vector/VectorSupport$StoreVectorOperation;)"                        \
+                                      "Ljdk/internal/vm/vector/VectorSupport$VectorPayload;"                                                   \
+                                      "Ljava/lang/Object;"                                                                                     \
+                                      "J"                                                                                                      \
+                                      "Ljdk/internal/vm/vector/VectorSupport$StoreVectorOperation;)"                                           \
                                       "V")                                                                                                     \
    do_name(vector_store_op_name,     "store")                                                                                                  \
                                                                                                                                                \
@@ -977,7 +979,7 @@ class methodHandle;
                                              "Ljdk/internal/vm/vector/VectorSupport$Vector;"                                                   \
                                              "Ljdk/internal/vm/vector/VectorSupport$VectorMask;"                                               \
                                              "Ljava/lang/Object;"                                                                              \
-                                             "I"                                                                                               \
+                                             "J"                                                                                               \
                                              "Ljdk/internal/vm/vector/VectorSupport$StoreVectorMaskedOperation;)"                              \
                                              "V")                                                                                              \
    do_name(vector_store_masked_op_name,     "storeMasked")                                                                                     \
@@ -1137,6 +1139,17 @@ class methodHandle;
                                         "J")                                                                                                   \
     do_name(vector_mask_oper_name, "maskReductionCoerced")                                                                                     \
                                                                                                                                                \
+  do_intrinsic(_VectorCompressExpand, jdk_internal_vm_vector_VectorSupport, vector_compress_expand_op_name, vector_compress_expand_op_sig, F_S)\
+   do_signature(vector_compress_expand_op_sig, "(I"                                                                                            \
+                                      "Ljava/lang/Class;"                                                                                      \
+                                      "Ljava/lang/Class;"                                                                                      \
+                                      "Ljava/lang/Class;"                                                                                      \
+                                      "I"                                                                                                      \
+                                      "Ljdk/internal/vm/vector/VectorSupport$Vector;"                                                          \
+                                      "Ljdk/internal/vm/vector/VectorSupport$VectorMask;"                                                      \
+                                      "Ljdk/internal/vm/vector/VectorSupport$CompressExpandOperation;)"                                        \
+                                      "Ljdk/internal/vm/vector/VectorSupport$VectorPayload;")                                                  \
+   do_name(vector_compress_expand_op_name,     "compressExpandOp")                                                                             \
    /* (2) Bytecode intrinsics                                                                        */                        \
                                                                                                                                \
   do_intrinsic(_park,                     jdk_internal_misc_Unsafe,     park_name, park_signature,                     F_RN)   \
@@ -1245,7 +1258,7 @@ enum class vmIntrinsicID : int {
                    __IGNORE_CLASS, __IGNORE_NAME, __IGNORE_SIGNATURE, __IGNORE_ALIAS)
 
   ID_LIMIT,
-  LAST_COMPILER_INLINE = _VectorMaskOp,
+  LAST_COMPILER_INLINE = _VectorCompressExpand,
   FIRST_MH_SIG_POLY    = _invokeGeneric,
   FIRST_MH_STATIC      = _linkToVirtual,
   LAST_MH_SIG_POLY     = _linkToNative,