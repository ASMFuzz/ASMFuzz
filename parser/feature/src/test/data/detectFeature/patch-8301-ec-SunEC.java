@@ -198,7 +198,7 @@ public Void run() {
     }
 
     void putEntries() {
-        HashMap<String, String> ATTRS = new HashMap<>(3);
+        HashMap<String, String> ATTRS = HashMap.newHashMap(3);
         ATTRS.put("ImplementedIn", "Software");
         String ecKeyClasses = "java.security.interfaces.ECPublicKey" +
                  "|java.security.interfaces.ECPrivateKey";
@@ -330,7 +330,7 @@ void putEntries() {
 
     private void putXDHEntries() {
 
-        HashMap<String, String> ATTRS = new HashMap<>(1);
+        HashMap<String, String> ATTRS = HashMap.newHashMap(1);
         ATTRS.put("ImplementedIn", "Software");
 
         putService(new ProviderService(this, "KeyFactory",
@@ -363,7 +363,7 @@ private void putXDHEntries() {
 
     private void putEdDSAEntries() {
 
-        HashMap<String, String> ATTRS = new HashMap<>(1);
+        HashMap<String, String> ATTRS = HashMap.newHashMap(1);
         ATTRS.put("ImplementedIn", "Software");
 
         putService(new ProviderService(this, "KeyFactory",