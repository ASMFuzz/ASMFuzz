@@ -157,8 +157,7 @@ private static void matchIP(String expectedIP, X509Certificate cert)
                                 InetAddress.getByName(ipAddress))) {
                             return;
                         }
-                    } catch (UnknownHostException e) {
-                    } catch (SecurityException e) {}
+                    } catch (UnknownHostException | SecurityException e) {}
                 }
             }
         }