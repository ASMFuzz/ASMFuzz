@@ -898,10 +898,6 @@ C2V_VMENTRY_0(jint, installCode, (JNIEnv *env, jobject, jobject target, jobject
   return result;
 C2V_END
 
-C2V_VMENTRY_0(jint, getMetadata, (JNIEnv *env, jobject, jobject target, jobject compiled_code, jobject metadata))
-  JVMCI_THROW_MSG_0(InternalError, "unimplemented");
-C2V_END
-
 C2V_VMENTRY(void, resetCompilationStatistics, (JNIEnv* env, jobject))
   JVMCICompiler* compiler = JVMCICompiler::instance(true, CHECK);
   CompilerStatistics* stats = compiler->stats();
@@ -1604,10 +1600,6 @@ C2V_VMENTRY_0(jint, methodDataProfileDataSize, (JNIEnv* env, jobject, jlong meta
   JVMCI_THROW_MSG_0(IllegalArgumentException, err_msg("Invalid profile data position %d", position));
 C2V_END
 
-C2V_VMENTRY_0(jlong, getFingerprint, (JNIEnv* env, jobject, jlong metaspace_klass))
-  JVMCI_THROW_MSG_0(InternalError, "unimplemented");
-C2V_END
-
 C2V_VMENTRY_NULL(jobject, getInterfaces, (JNIEnv* env, jobject, jobject jvmci_type))
   if (jvmci_type == NULL) {
     JVMCI_THROW_0(NullPointerException);
@@ -2744,7 +2736,6 @@ JNINativeMethod CompilerToVM::methods[] = {
   {CC "getResolvedJavaType0",                         CC "(Ljava/lang/Object;JZ)" HS_RESOLVED_KLASS,                                        FN_PTR(getResolvedJavaType0)},
   {CC "readConfiguration",                            CC "()[" OBJECT,                                                                      FN_PTR(readConfiguration)},
   {CC "installCode",                                  CC "(" TARGET_DESCRIPTION HS_COMPILED_CODE INSTALLED_CODE "J[B)I",                    FN_PTR(installCode)},
-  {CC "getMetadata",                                  CC "(" TARGET_DESCRIPTION HS_COMPILED_CODE HS_METADATA ")I",                          FN_PTR(getMetadata)},
   {CC "resetCompilationStatistics",                   CC "()V",                                                                             FN_PTR(resetCompilationStatistics)},
   {CC "disassembleCodeBlob",                          CC "(" INSTALLED_CODE ")" STRING,                                                     FN_PTR(disassembleCodeBlob)},
   {CC "executeHotSpotNmethod",                        CC "([" OBJECT HS_NMETHOD ")" OBJECT,                                                 FN_PTR(executeHotSpotNmethod)},
@@ -2766,7 +2757,6 @@ JNINativeMethod CompilerToVM::methods[] = {
   {CC "writeDebugOutput",                             CC "(JIZ)V",                                                                          FN_PTR(writeDebugOutput)},
   {CC "flushDebugOutput",                             CC "()V",                                                                             FN_PTR(flushDebugOutput)},
   {CC "methodDataProfileDataSize",                    CC "(JI)I",                                                                           FN_PTR(methodDataProfileDataSize)},
-  {CC "getFingerprint",                               CC "(J)J",                                                                            FN_PTR(getFingerprint)},
   {CC "interpreterFrameSize",                         CC "(" BYTECODE_FRAME ")I",                                                           FN_PTR(interpreterFrameSize)},
   {CC "compileToBytecode",                            CC "(" OBJECTCONSTANT ")V",                                                           FN_PTR(compileToBytecode)},
   {CC "getFlagValue",                                 CC "(" STRING ")" OBJECT,                                                             FN_PTR(getFlagValue)},