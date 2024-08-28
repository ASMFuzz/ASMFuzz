@@ -134,7 +134,7 @@ private System() {
      * specified by the host environment or user. The encoding used
      * in the conversion from characters to bytes is equivalent to
      * {@link Console#charset()} if the {@code Console} exists,
-     * {@link Charset#defaultCharset()} otherwise.
+     * <a href="#stdout.encoding">stdout.encoding</a> otherwise.
      * <p>
      * For simple stand-alone Java applications, a typical way to write
      * a line of output data is:
@@ -155,7 +155,7 @@ private System() {
      * @see     java.io.PrintStream#println(java.lang.Object)
      * @see     java.io.PrintStream#println(java.lang.String)
      * @see     Console#charset()
-     * @see     Charset#defaultCharset()
+     * @see     <a href="#stdout.encoding">stdout.encoding</a>
      */
     public static final PrintStream out = null;
 
@@ -172,10 +172,10 @@ private System() {
      * destination that is typically not continuously monitored.
      * The encoding used in the conversion from characters to bytes is
      * equivalent to {@link Console#charset()} if the {@code Console}
-     * exists, {@link Charset#defaultCharset()} otherwise.
+     * exists, <a href="#stderr.encoding">stderr.encoding</a> otherwise.
      *
      * @see     Console#charset()
-     * @see     Charset#defaultCharset()
+     * @see     <a href="#stderr.encoding">stderr.encoding</a>
      */
     public static final PrintStream err = null;
 
@@ -768,6 +768,14 @@ public static native void arraycopy(Object src,  int  srcPos,
      * <tr><th scope="row">{@systemProperty native.encoding}</th>
      *     <td>Character encoding name derived from the host environment and/or
      *     the user's settings. Setting this system property has no effect.</td></tr>
+     * <tr><th scope="row">{@systemProperty stdout.encoding}</th>
+     *     <td>Character encoding name for {@link System#out System.out}.
+     *     The Java runtime can be started with the system property set to {@code UTF-8},
+     *     starting it with the property set to another value leads to undefined behavior.
+     * <tr><th scope="row">{@systemProperty stderr.encoding}</th>
+     *     <td>Character encoding name for {@link System#err System.err}.
+     *     The Java runtime can be started with the system property set to {@code UTF-8},
+     *     starting it with the property set to another value leads to undefined behavior.
      * </tbody>
      * </table>
      * <p>
@@ -2144,11 +2152,11 @@ private static void initPhase1() {
         FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
         FileOutputStream fdErr = new FileOutputStream(FileDescriptor.err);
         setIn0(new BufferedInputStream(fdIn));
-        // sun.stdout/err.encoding are set when the VM is associated with the terminal,
-        // thus they are equivalent to Console.charset(), otherwise the encoding
-        // defaults to native.encoding
-        setOut0(newPrintStream(fdOut, props.getProperty("sun.stdout.encoding", StaticProperty.nativeEncoding())));
-        setErr0(newPrintStream(fdErr, props.getProperty("sun.stderr.encoding", StaticProperty.nativeEncoding())));
+        // stdout/err.encoding are set when the VM is associated with the terminal,
+        // thus they are equivalent to Console.charset(), otherwise the encodings
+        // of those properties default to native.encoding
+        setOut0(newPrintStream(fdOut, props.getProperty("stdout.encoding")));
+        setErr0(newPrintStream(fdErr, props.getProperty("stderr.encoding")));
 
         // Setup Java signal handlers for HUP, TERM, and INT (where available).
         Terminator.setup();