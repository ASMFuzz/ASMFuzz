@@ -33,7 +33,7 @@
  *     Incorrect checking of proxy server response
  * @modules jdk.crypto.ec
  *          java.base/sun.net.www
- * @library /javax/net/ssl/templates
+ * @library /test/lib /javax/net/ssl/templates
  * @run main/othervm ProxyAuthTest fail
  * @run main/othervm -Djdk.http.auth.tunneling.disabledSchemes=Basic
  *      ProxyAuthTest fail