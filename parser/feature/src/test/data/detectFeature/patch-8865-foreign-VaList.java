@@ -71,7 +71,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      * @param layout the layout of the value to be read.
      * @return the {@code int} value read from this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     int nextVarg(ValueLayout.OfInt layout);
 
@@ -82,7 +84,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      * @param layout the layout of the value to be read.
      * @return the {@code long} value read from this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     long nextVarg(ValueLayout.OfLong layout);
 
@@ -93,7 +97,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      * @param layout the layout of the value
      * @return the {@code double} value read from this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     double nextVarg(ValueLayout.OfDouble layout);
 
@@ -104,7 +110,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      * @param layout the layout of the value to be read.
      * @return the {@code MemoryAddress} value read from this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     MemoryAddress nextVarg(ValueLayout.OfAddress layout);
 
@@ -124,7 +132,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      *                  will be copied.
      * @return the {@code MemorySegment} value read from this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     MemorySegment nextVarg(GroupLayout layout, SegmentAllocator allocator);
 
@@ -133,7 +143,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      *
      * @param layouts the layouts of the values to be skipped.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     void skip(MemoryLayout... layouts);
 
@@ -148,14 +160,18 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      *
      * @return a copy of this variable argument list.
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     VaList copy();
 
     /**
      * {@return the {@linkplain MemoryAddress memory address} associated with this variable argument list}
      * @throws IllegalStateException if the {@linkplain #session() session} associated with this variable argument list is not
-     * {@linkplain MemorySession#isAlive() alive}, or if access occurs from a thread other than the thread owning that session.
+     * {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread owning
+     * the {@linkplain #session() session} associated with this variable argument list.
      */
     @Override
     MemoryAddress address();
@@ -172,8 +188,9 @@ sealed public interface VaList extends Addressable permits WinVaList, SysVVaList
      * @param address a memory address pointing to an existing variable argument list.
      * @param session the memory session to be associated with the returned variable argument list.
      * @return a new variable argument list backed by the memory region at {@code address}.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      * @throws UnsupportedOperationException if the underlying native platform is not supported.
      * @throws IllegalCallerException if access to this method occurs from a module {@code M} and the command line option
      * {@code --enable-native-access} is specified, but does not mention the module name {@code M}, or
@@ -202,8 +219,9 @@ static VaList ofAddress(MemoryAddress address, MemorySession session) {
      * @param session the memory session to be associated with the new variable arity list.
      * @return a new variable argument list.
      * @throws UnsupportedOperationException if the underlying native platform is not supported.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static VaList make(Consumer<Builder> actions, MemorySession session) {
         Objects.requireNonNull(actions);