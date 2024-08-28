@@ -559,6 +559,7 @@
   template(char_array_void_signature,                 "([C)V")                                                    \
   template(int_int_void_signature,                    "(II)V")                                                    \
   template(long_long_void_signature,                  "(JJ)V")                                                    \
+  template(void_byte_array_signature,                 "()[B")                                                    \
   template(void_classloader_signature,                "()Ljava/lang/ClassLoader;")                                \
   template(void_object_signature,                     "()Ljava/lang/Object;")                                     \
   template(void_class_signature,                      "()Ljava/lang/Class;")                                      \
@@ -681,7 +682,6 @@
   template(appendToClassPathForInstrumentation_name,   "appendToClassPathForInstrumentation")                     \
   do_alias(appendToClassPathForInstrumentation_signature, string_void_signature)                                  \
   template(serializePropertiesToByteArray_name,        "serializePropertiesToByteArray")                          \
-  template(serializePropertiesToByteArray_signature,   "()[B")                                                    \
   template(serializeAgentPropertiesToByteArray_name,   "serializeAgentPropertiesToByteArray")                     \
   template(classRedefinedCount_name,                   "classRedefinedCount")                                     \
   template(classLoader_name,                           "classLoader")                                             \