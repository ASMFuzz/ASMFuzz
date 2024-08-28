@@ -31,7 +31,6 @@
 
 enum ReferenceType {
   REF_NONE,      // Regular class
-  REF_OTHER,     // Subclass of java/lang/ref/Reference, but not subclass of one of the classes below
   REF_SOFT,      // Subclass of java/lang/ref/SoftReference
   REF_WEAK,      // Subclass of java/lang/ref/WeakReference
   REF_FINAL,     // Subclass of java/lang/ref/FinalReference