@@ -58,6 +58,9 @@ public static void main(String[] args) throws IOException {
     public static void testDatagramChannel() throws IOException {
         try (DatagramChannel c1 = DatagramChannel.open()) {
 
+            if (!c1.supportedOptions().contains(IP_DONTFRAGMENT)) {
+                throw new RuntimeException("IP_DONTFRAGMENT not supported");
+            }
             if (c1.getOption(IP_DONTFRAGMENT)) {
                 throw new RuntimeException("IP_DONTFRAGMENT should not be set");
             }
@@ -75,6 +78,9 @@ public static void testDatagramChannel() throws IOException {
     public static void testDatagramChannel(String[] args, ProtocolFamily fam) throws IOException {
         try (DatagramChannel c1 = DatagramChannel.open(fam)) {
 
+            if (!c1.supportedOptions().contains(IP_DONTFRAGMENT)) {
+                throw new RuntimeException("IP_DONTFRAGMENT not supported");
+            }
             if (c1.getOption(IP_DONTFRAGMENT)) {
                 throw new RuntimeException("IP_DONTFRAGMENT should not be set");
             }
@@ -90,6 +96,9 @@ public static void testDatagramChannel(String[] args, ProtocolFamily fam) throws
     }
 
     public static void testDatagramSocket(DatagramSocket c1) throws IOException {
+        if (!c1.supportedOptions().contains(IP_DONTFRAGMENT)) {
+            throw new RuntimeException("IP_DONTFRAGMENT not supported");
+        }
         if (c1.getOption(IP_DONTFRAGMENT)) {
             throw new RuntimeException("IP_DONTFRAGMENT should not be set");
         }