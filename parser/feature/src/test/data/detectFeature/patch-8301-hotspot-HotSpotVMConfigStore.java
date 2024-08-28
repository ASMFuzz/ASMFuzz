@@ -120,10 +120,10 @@ public List<VMIntrinsicMethod> getIntrinsics() {
         Object[] vmAddressesInfo  = (Object[])  data[2];
         VMFlag[] vmFlagsInfo      = (VMFlag[])  data[3];
 
-        vmFields     = new HashMap<>(vmFieldsInfo.length);
-        vmConstants  = new HashMap<>(vmConstantsInfo.length);
-        vmAddresses  = new HashMap<>(vmAddressesInfo.length);
-        vmFlags      = new HashMap<>(vmFlagsInfo.length);
+        vmFields     = HashMap.newHashMap(vmFieldsInfo.length);
+        vmConstants  = HashMap.newHashMap(vmConstantsInfo.length);
+        vmAddresses  = HashMap.newHashMap(vmAddressesInfo.length);
+        vmFlags      = HashMap.newHashMap(vmFlagsInfo.length);
         vmIntrinsics = Arrays.asList((VMIntrinsicMethod[]) data[4]);
         // @formatter:on
 