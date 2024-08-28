@@ -36,7 +36,7 @@
 
 #elif defined(_MSC_VER)
 
-// Use MSVC instrinsic: https://docs.microsoft.com/en-us/cpp/intrinsics/arm64-intrinsics?view=vs-2019#I
+// Use MSVC intrinsic: https://docs.microsoft.com/en-us/cpp/intrinsics/arm64-intrinsics?view=vs-2019#I
 #define NOP() __nop();
 
 #endif
@@ -593,7 +593,7 @@ class Address {
   }
 };
 
-// Convience classes
+// Convenience classes
 class RuntimeAddress: public Address {
 
   public: