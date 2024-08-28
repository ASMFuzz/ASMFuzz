@@ -141,7 +141,7 @@ static GSSNameImpl wrapElement(GSSManagerImpl gssManager,
         appNameStr = printableName = mechElement.toString();
         appNameType = printableNameType = mechElement.getStringNameType();
         this.mechElement = mechElement;
-        elements = new HashMap<Oid, GSSNameSpi>(1);
+        elements = HashMap.newHashMap(1);
         elements.put(mechElement.getMechanism(), this.mechElement);
     }
 
@@ -179,7 +179,7 @@ private void init(GSSManagerImpl gssManager,
 
         this.gssManager = gssManager;
         this.elements =
-                new HashMap<Oid, GSSNameSpi>(gssManager.getMechs().length);
+                HashMap.newHashMap(gssManager.getMechs().length);
 
         if (appName instanceof String) {
             this.appNameStr = (String) appName;