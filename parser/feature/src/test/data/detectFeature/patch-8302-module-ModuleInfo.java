@@ -446,7 +446,7 @@ private Builder readModuleAttribute(DataInput in, ConstantPool cpool, int major)
 
                 int exports_to_count = in.readUnsignedShort();
                 if (exports_to_count > 0) {
-                    Set<String> targets = new HashSet<>(exports_to_count);
+                    Set<String> targets = HashSet.newHashSet(exports_to_count);
                     for (int j=0; j<exports_to_count; j++) {
                         int exports_to_index = in.readUnsignedShort();
                         String target = cpool.getModuleName(exports_to_index);
@@ -486,7 +486,7 @@ private Builder readModuleAttribute(DataInput in, ConstantPool cpool, int major)
 
                 int open_to_count = in.readUnsignedShort();
                 if (open_to_count > 0) {
-                    Set<String> targets = new HashSet<>(open_to_count);
+                    Set<String> targets = HashSet.newHashSet(open_to_count);
                     for (int j=0; j<open_to_count; j++) {
                         int opens_to_index = in.readUnsignedShort();
                         String target = cpool.getModuleName(opens_to_index);
@@ -540,7 +540,7 @@ private Set<String> readModulePackagesAttribute(DataInput in, ConstantPool cpool
         throws IOException
     {
         int package_count = in.readUnsignedShort();
-        Set<String> packages = new HashSet<>(package_count);
+        Set<String> packages = HashSet.newHashSet(package_count);
         for (int i=0; i<package_count; i++) {
             int index = in.readUnsignedShort();
             String pn = cpool.getPackageName(index);