@@ -387,7 +387,7 @@ boolean isMCOrgLocal() {
         holder6 = new Inet6AddressHolder();
         try {
             initif (hostName, addr, null);
-        } catch (UnknownHostException e) {} /* cant happen if ifname is null */
+        } catch (UnknownHostException e) {} /* can't happen if ifname is null */
     }
 
     Inet6Address (String hostName, byte[] addr, NetworkInterface nif)