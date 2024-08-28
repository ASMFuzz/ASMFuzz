@@ -755,8 +755,8 @@ public SSLEngineResult unwrap(ByteBuffer src,
      * The underlying memory used by the {@code src} and
      * {@code dsts ByteBuffer}s must not be the same.
      * <P>
-     * The inbound network buffer may be modified as a result of this
-     * call:  therefore if the network data packet is required for some
+     * The inbound network buffer, {@code src}, may be modified as a result of
+     * this call:  therefore if the network data packet is required for some
      * secondary purpose, the data should be duplicated before calling this
      * method.  Note:  the network data will not be useful to a second
      * SSLEngine, as each SSLEngine contains unique random state which