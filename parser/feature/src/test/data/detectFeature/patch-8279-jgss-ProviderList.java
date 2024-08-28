@@ -134,8 +134,10 @@ public ProviderList(GSSCaller caller, boolean useNative) {
                 addProviderAtEnd(prov, null);
             } catch (GSSException ge) {
                 // Move on to the next provider
-                GSSUtil.debug("Error in adding provider " +
-                              prov.getName() + ": " + ge);
+                if (GSSUtil.DEBUG) {
+                    GSSUtil.debug("Error in adding provider " +
+                            prov.getName() + ": " + ge);
+                }
             }
         } // End of for loop
     }
@@ -421,8 +423,10 @@ private boolean addAllMechsFromProvider(Provider p) {
                     retVal = true;
                 } catch (GSSException e) {
                     // Skip to next property
-                    GSSUtil.debug("Ignore the invalid property " +
-                                  prop + " from provider " + p.getName());
+                    if (GSSUtil.DEBUG) {
+                        GSSUtil.debug("Ignore the invalid property " +
+                                prop + " from provider " + p.getName());
+                    }
                 }
             } // Processed GSS property
         } // while loop