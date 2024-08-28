@@ -21,7 +21,7 @@
  * under the License.
  */
 /*
- * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 package org.jcp.xml.dsig.internal.dom;
 
@@ -300,35 +300,23 @@ DSAPublicKey unmarshalKeyValue(Element kvtElem)
                         ("unable to create DSA KeyFactory: " + e.getMessage());
                 }
             }
-            Element curElem = DOMUtils.getFirstChildElement(kvtElem);
-            if (curElem == null) {
-                throw new MarshalException("KeyValue must contain at least one type");
-            }
-            // check for P and Q
-            BigInteger p = null;
-            BigInteger q = null;
-            if ("P".equals(curElem.getLocalName()) && XMLSignature.XMLNS.equals(curElem.getNamespaceURI())) {
-                p = decode(curElem);
-                curElem = DOMUtils.getNextSiblingElement(curElem, "Q", XMLSignature.XMLNS);
-                q = decode(curElem);
-                curElem = DOMUtils.getNextSiblingElement(curElem);
-            }
-            BigInteger g = null;
-            if (curElem != null
-                && "G".equals(curElem.getLocalName()) && XMLSignature.XMLNS.equals(curElem.getNamespaceURI())) {
-                g = decode(curElem);
-                curElem = DOMUtils.getNextSiblingElement(curElem, "Y", XMLSignature.XMLNS);
-            }
-            BigInteger y = null;
-            if (curElem != null) {
-                y = decode(curElem);
-                curElem = DOMUtils.getNextSiblingElement(curElem);
-            }
-            //if (curElem != null && "J".equals(curElem.getLocalName())) {
-                //j = new DOMCryptoBinary(curElem.getFirstChild());
-                // curElem = DOMUtils.getNextSiblingElement(curElem);
-            //}
-            //@@@ do we care about j, pgenCounter or seed?
+            // P, Q, and G are optional according to the XML Signature
+            // Recommendation as they might be known from application context,
+            // but this implementation does not provide a mechanism or API for
+            // an application to supply the missing parameters, so they are
+            // required to be specified.
+            Element curElem =
+                DOMUtils.getFirstChildElement(kvtElem, "P", XMLSignature.XMLNS);
+            BigInteger p = decode(curElem);
+            curElem =
+                DOMUtils.getNextSiblingElement(curElem, "Q", XMLSignature.XMLNS);
+            BigInteger q = decode(curElem);
+            curElem =
+                DOMUtils.getNextSiblingElement(curElem, "G", XMLSignature.XMLNS);
+            BigInteger g = decode(curElem);
+            curElem =
+                DOMUtils.getNextSiblingElement(curElem, "Y", XMLSignature.XMLNS);
+            BigInteger y = decode(curElem);
             DSAPublicKeySpec spec = new DSAPublicKeySpec(y, p, q, g);
             return (DSAPublicKey) generatePublicKey(dsakf, spec);
         }