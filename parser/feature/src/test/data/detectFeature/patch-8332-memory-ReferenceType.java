@@ -28,7 +28,6 @@
 
 public enum ReferenceType {
   REF_NONE ("None reference"),       // Regular class
-  REF_OTHER ("Other reference"),     // Subclass of java/lang/ref/Reference, but not subclass of one of the classes below
   REF_SOFT ("Soft reference"),       // Subclass of java/lang/ref/SoftReference
   REF_WEAK ("Weak reference"),       // Subclass of java/lang/ref/WeakReference
   REF_FINAL ("Final reference"),     // Subclass of java/lang/ref/FinalReference