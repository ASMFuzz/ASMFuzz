@@ -113,7 +113,7 @@ public interface Key extends java.io.Serializable {
     @Deprecated
     @SuppressWarnings("serial")
     @java.io.Serial
-    static final long serialVersionUID = 6603384152749567654L;
+   long serialVersionUID = 6603384152749567654L;
 
     /**
      * Returns the standard algorithm name for this key. For
@@ -126,7 +126,7 @@ public interface Key extends java.io.Serializable {
      *
      * @return the name of the algorithm associated with this key.
      */
-    public String getAlgorithm();
+    String getAlgorithm();
 
     /**
      * Returns the name of the primary encoding format of this key,
@@ -145,7 +145,7 @@ public interface Key extends java.io.Serializable {
      *
      * @return the primary encoding format of the key.
      */
-    public String getFormat();
+    String getFormat();
 
     /**
      * Returns the key in its primary encoding format, or null
@@ -154,5 +154,5 @@ public interface Key extends java.io.Serializable {
      * @return the encoded key, or null if the key does not support
      * encoding.
      */
-    public byte[] getEncoded();
+    byte[] getEncoded();
 }