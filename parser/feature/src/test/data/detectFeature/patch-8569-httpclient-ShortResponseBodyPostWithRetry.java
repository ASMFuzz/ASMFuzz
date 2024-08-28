@@ -23,12 +23,13 @@
 
 /*
  * @test
- * @summary Run of ShortResponseBody with -Djdk.httpclient.enableAllMethodRetry
+ * @summary Run of ShortResponseBodyPost with -Djdk.httpclient.enableAllMethodRetry
  * @library /test/lib
  * @build jdk.test.lib.net.SimpleSSLContext
- * @build ShortResponseBody
+ * @build ShortResponseBody ShortResponseBodyPost
  * @run testng/othervm
  *       -Djdk.httpclient.HttpClient.log=headers,errors,channel
  *       -Djdk.httpclient.enableAllMethodRetry
- *       ShortResponseBody
+ *       -Djdk.internal.httpclient.debug=true
+ *       ShortResponseBodyPost
  */