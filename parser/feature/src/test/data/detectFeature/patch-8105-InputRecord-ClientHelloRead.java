@@ -24,6 +24,7 @@
 /*
  * @test
  * @bug 4432868
+ * @library /test/lib
  * @summary A client-hello message may not always be read correctly
  * @modules java.base/sun.net.www
  * @run main/othervm ClientHelloRead