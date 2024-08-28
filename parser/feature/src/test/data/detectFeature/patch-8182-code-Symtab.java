@@ -189,6 +189,7 @@ public static Symtab instance(Context context) {
     public final Type assertionErrorType;
     public final Type incompatibleClassChangeErrorType;
     public final Type cloneNotSupportedExceptionType;
+    public final Type matchExceptionType;
     public final Type annotationType;
     public final TypeSymbol enumSym;
     public final Type listType;
@@ -553,6 +554,7 @@ public <R, P> R accept(ElementVisitor<R, P> v, P p) {
         assertionErrorType = enterClass("java.lang.AssertionError");
         incompatibleClassChangeErrorType = enterClass("java.lang.IncompatibleClassChangeError");
         cloneNotSupportedExceptionType = enterClass("java.lang.CloneNotSupportedException");
+        matchExceptionType = enterClass("java.lang.MatchException");
         annotationType = enterClass("java.lang.annotation.Annotation");
         classLoaderType = enterClass("java.lang.ClassLoader");
         enumSym = enterClass(java_base, names.java_lang_Enum);