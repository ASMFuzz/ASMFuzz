@@ -24,7 +24,6 @@
 import com.sun.org.apache.xml.internal.utils.PrefixResolver;
 import com.sun.org.apache.xpath.internal.res.XPATHErrorResources;
 import java.util.List;
-import java.util.Objects;
 import javax.xml.transform.TransformerException;
 import jdk.xml.internal.XMLSecurityManager;
 import jdk.xml.internal.XMLSecurityManager.Limit;
@@ -33,7 +32,7 @@
  * This class is in charge of lexical processing of the XPath
  * expression into tokens.
  *
- * @LastModified: Jan 2022
+ * @LastModified: Apr 2022
  */
 class Lexer
 {
@@ -451,8 +450,7 @@ else if (null != targetStrings)
    * @return the next char
    */
   private char peekNext(String s, int index) {
-      Objects.checkIndex(index, s.length());
-      if (s.length() > index) {
+      if (index >= 0 && index < s.length() - 1) {
           return s.charAt(index + 1);
       }
       return 0;