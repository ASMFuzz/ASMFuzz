@@ -148,7 +148,7 @@ public OpeningHandshake(BuilderImpl b) {
     private static Collection<String> createRequestSubprotocols(
             Collection<String> subprotocols)
     {
-        LinkedHashSet<String> sp = new LinkedHashSet<>(subprotocols.size(), 1);
+        LinkedHashSet<String> sp = LinkedHashSet.newLinkedHashSet(subprotocols.size());
         for (String s : subprotocols) {
             if (s.trim().isEmpty() || !isValidName(s)) {
                 throw illegal("Bad subprotocol syntax: " + s);