@@ -614,6 +614,9 @@ public Void run() {
                 pe.add(new PropertyPermission
                                 ("java.specification.version",
                                     SecurityConstants.PROPERTY_READ_ACTION));
+                pe.add(new PropertyPermission
+                                ("java.specification.maintenance.version",
+                                    SecurityConstants.PROPERTY_READ_ACTION));
                 pe.add(new PropertyPermission
                                 ("java.specification.vendor",
                                     SecurityConstants.PROPERTY_READ_ACTION));