@@ -1040,21 +1040,21 @@ private static void postDeregisterInvoke(ObjectName mbean,
         } catch (RuntimeException e) {
             MBEANSERVER_LOGGER.log(Level.DEBUG, "While unregistering MBean ["+mbean+
                     "]: " + "Exception thrown by postDeregister: " +
-                    "rethrowing <"+e+">, although the MBean is succesfully " +
+                    "rethrowing <"+e+">, although the MBean is successfully " +
                     "unregistered");
             throw new RuntimeMBeanException(e,
                       "RuntimeException thrown in postDeregister method: "+
                       "rethrowing <"+e+
-                      ">, although the MBean is sucessfully unregistered");
+                      ">, although the MBean is successfully unregistered");
         } catch (Error er) {
             MBEANSERVER_LOGGER.log(Level.DEBUG, "While unregistering MBean ["+mbean+
                     "]: " + "Error thrown by postDeregister: " +
-                    "rethrowing <"+er+">, although the MBean is succesfully " +
+                    "rethrowing <"+er+">, although the MBean is successfully " +
                     "unregistered");
             throw new RuntimeErrorException(er,
                       "Error thrown in postDeregister method: "+
                       "rethrowing <"+er+
-                      ">, although the MBean is sucessfully unregistered");
+                      ">, although the MBean is successfully unregistered");
         }
     }
 