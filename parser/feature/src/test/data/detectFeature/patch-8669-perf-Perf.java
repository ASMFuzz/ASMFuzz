@@ -179,63 +179,9 @@ public static Perf getPerf()
      *                           into the virtual machine's address space.
      * @see     java.nio.ByteBuffer
      */
-    public ByteBuffer attach(int lvmid)
-           throws IllegalArgumentException, IOException
+    public ByteBuffer attach(int lvmid) throws IOException
     {
-        return attachImpl(null, lvmid);
-    }
-
-    /**
-     * Attach to the instrumentation buffer for the specified Java virtual
-     * machine owned by the given user.
-     * <p>
-     * This method behaves just as the <code>attach(int lvmid)
-     * </code> method, except that it only searches for Java virtual machines
-     * owned by the specified user.
-     *
-     * @param   user             A <code>String</code> object containing the
-     *                           name of the user that owns the target Java
-     *                           virtual machine.
-     * @param   lvmid            an integer that uniquely identifies the
-     *                           target local Java virtual machine.
-     * @return  ByteBuffer       a direct allocated byte buffer
-     * @throws  IllegalArgumentException  The lvmid was invalid.
-     * @throws  IOException      An I/O error occurred while trying to acquire
-     *                           the instrumentation buffer.
-     * @throws  OutOfMemoryError The instrumentation buffer could not be mapped
-     *                           into the virtual machine's address space.
-     * @see     java.nio.ByteBuffer
-     */
-    public ByteBuffer attach(String user, int lvmid)
-           throws IllegalArgumentException, IOException
-    {
-        return attachImpl(user, lvmid);
-    }
-
-    /**
-     * Call the implementation specific attach method.
-     * <p>
-     * This method calls into the Java virtual machine to perform the platform
-     * specific attach method. Buffers returned from this method are
-     * internally managed as <code>PhantomRefereces</code> to provide for
-     * guaranteed, secure release of the native resources.
-     *
-     * @param   user             A <code>String</code> object containing the
-     *                           name of the user that owns the target Java
-     *                           virtual machine.
-     * @param   lvmid            an integer that uniquely identifies the
-     *                           target local Java virtual machine.
-     * @return  ByteBuffer       a direct allocated byte buffer
-     * @throws  IllegalArgumentException  The lvmid was invalid.
-     * @throws  IOException      An I/O error occurred while trying to acquire
-     *                           the instrumentation buffer.
-     * @throws  OutOfMemoryError The instrumentation buffer could not be mapped
-     *                           into the virtual machine's address space.
-     */
-    private ByteBuffer attachImpl(String user, int lvmid)
-            throws IllegalArgumentException, IOException
-    {
-        final ByteBuffer b = attach0(user, lvmid);
+        final ByteBuffer b = attach0(lvmid);
 
         if (lvmid == 0) {
             // The native instrumentation buffer for this Java virtual
@@ -286,9 +232,6 @@ public void run() {
      * target Java virtual machine will result in two distinct ByteBuffer
      * objects returned by this method. This may change in a future release.
      *
-     * @param   user             A <code>String</code> object containing the
-     *                           name of the user that owns the target Java
-     *                           virtual machine.
      * @param   lvmid            an integer that uniquely identifies the
      *                           target local Java virtual machine.
      * @return  ByteBuffer       a direct allocated byte buffer
@@ -298,8 +241,7 @@ public void run() {
      * @throws  OutOfMemoryError The instrumentation buffer could not be mapped
      *                           into the virtual machine's address space.
      */
-    private native ByteBuffer attach0(String user, int lvmid)
-                   throws IllegalArgumentException, IOException;
+    private native ByteBuffer attach0(int lvmid) throws IOException;
 
     /**
      * Native method to perform the implementation specific detach mechanism.