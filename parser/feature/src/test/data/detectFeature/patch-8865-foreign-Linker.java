@@ -127,7 +127,7 @@
  *     <li>The memory session of {@code R} is {@linkplain MemorySession#isAlive() alive}. Otherwise, the invocation throws
  *     {@link IllegalStateException};</li>
  *     <li>The invocation occurs in same thread as the one {@linkplain MemorySession#ownerThread() owning} the memory session of {@code R},
- *     if said session is confined. Otherwise, the invocation throws {@link IllegalStateException}; and</li>
+ *     if said session is confined. Otherwise, the invocation throws {@link WrongThreadException}; and</li>
  *     <li>The memory session of {@code R} is {@linkplain MemorySession#whileAlive(Runnable) kept alive} (and cannot be closed) during the invocation.</li>
  *</ul>
  * <p>
@@ -262,8 +262,9 @@ default MethodHandle downcallHandle(Addressable symbol, FunctionDescriptor funct
      * @throws IllegalArgumentException if the provided function descriptor is not supported by this linker.
      * @throws IllegalArgumentException if it is determined that the target method handle can throw an exception, or if the target method handle
      * has a type that does not match the upcall stub <a href="CLinker.html#upcall-stubs"><em>inferred type</em></a>.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     MemorySegment upcallStub(MethodHandle target, FunctionDescriptor function, MemorySession session);
 