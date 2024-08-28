@@ -201,19 +201,39 @@ class G1CardSet : public CHeapObj<mtGCCardSet> {
   //
   // Possible encodings:
   //
-  // 0...00000 free               (Empty, should never happen)
+  // 0...00000 free               (Empty, should never happen on a top-level ContainerPtr)
   // 1...11111 full               All card indexes in the whole area this ContainerPtr covers are part of this container.
   // X...XXX00 inline-ptr-cards   A handful of card indexes covered by this ContainerPtr are encoded within the ContainerPtr.
   // X...XXX01 array of cards     The container is a contiguous array of card indexes.
   // X...XXX10 bitmap             The container uses a bitmap to determine whether a given index is part of this set.
   // X...XXX11 howl               This is a card set container containing an array of ContainerPtr, with each ContainerPtr
   //                              limited to a sub-range of the original range. Currently only one level of this
   //                              container is supported.
-  using ContainerPtr = void*;
+  //
+  // The container's pointer starts off with an inline container and is then subsequently
+  // coarsened as more cards are added.
+  //
   // Coarsening happens in the order below:
-  // ContainerInlinePtr -> ContainerArrayOfCards -> ContainerHowl -> Full
-  // Corsening of containers inside the ContainerHowl happens in the order:
-  // ContainerInlinePtr -> ContainerArrayOfCards -> ContainerBitMap -> Full
+  //   ContainerInlinePtr -> ContainerArrayOfCards -> ContainerHowl -> Full
+  //
+  // There is intentionally no bitmap based container that covers a full region; first,
+  // a whole region is covered very well (and more flexibly) using the howl container and
+  // even then the overhead of the ContainerPtr array with all-bitmaps vs. a single bitmap
+  // is negligible, and most importantly transferring such a Howl container to a
+  // "Full Region Bitmap" is fairly hard without missing entries that are added by
+  // concurrent threads.
+  //
+  // Howl containers are basically arrays of containers. An entry starts off with
+  // Free. Further corsening of containers inside the ContainerHowl happens in the order:
+  //
+  //   Free -> ContainerInlinePtr -> ContainerArrayOfCards -> ContainerBitMap -> Full
+  //
+  // Throughout the code it is assumed (and checked) that the last two bits of the encoding
+  // for Howl (0b11) is assumed to be the same as the last two bits for "FullCardSet"; this
+  // has been done in various places to not be required to check for a "FullCardSet" first
+  // all the time in iteration code (only if there is a Howl card set container, that is
+  // fairly uncommon).
+  using ContainerPtr = void*;
   static const uintptr_t ContainerInlinePtr      = 0x0;
   static const uintptr_t ContainerArrayOfCards   = 0x1;
   static const uintptr_t ContainerBitMap         = 0x2;