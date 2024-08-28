@@ -379,22 +379,6 @@ public static CompilerToVM compilerToVM() {
      */
     native int installCode(TargetDescription target, HotSpotCompiledCode compiledCode, InstalledCode code, long failedSpeculationsAddress, byte[] speculations);
 
-    /**
-     * Generates the VM metadata for some compiled code and copies them into {@code metaData}. This
-     * method does not install anything into the code cache.
-     *
-     * @param target the target where this code would be installed
-     * @param compiledCode the result of a compilation
-     * @param metaData the metadata is written to this object
-     * @return the outcome of the installation which will be one of
-     *         {@link HotSpotVMConfig#codeInstallResultOk},
-     *         {@link HotSpotVMConfig#codeInstallResultCacheFull},
-     *         {@link HotSpotVMConfig#codeInstallResultCodeTooLarge} or
-     *         {@link HotSpotVMConfig#codeInstallResultDependenciesFailed}.
-     * @throws JVMCIError if there is something wrong with the compiled code or the metadata
-     */
-    native int getMetadata(TargetDescription target, HotSpotCompiledCode compiledCode, HotSpotMetaData metaData);
-
     /**
      * Resets all compilation statistics.
      */
@@ -688,14 +672,6 @@ HotSpotResolvedObjectTypeImpl getResolvedJavaType(long displacement, boolean com
      */
     native int methodDataProfileDataSize(long metaspaceMethodData, int position);
 
-    /**
-     * Gets the fingerprint for a given Klass*.
-     *
-     * @param metaspaceKlass
-     * @return the value of the fingerprint (zero for arrays and synthetic classes).
-     */
-    native long getFingerprint(long metaspaceKlass);
-
     /**
      * Return the amount of native stack required for the interpreter frames represented by
      * {@code frame}. This is used when emitting the stack banging code to ensure that there is