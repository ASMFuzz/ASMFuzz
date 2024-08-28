@@ -131,7 +131,7 @@ class ZipDecompressor : public ImageDecompressor {
  * Shared Strings decompressor. This decompressor reconstruct the class
  * constant pool UTF_U entries by retrieving strings stored in jimage strings table.
  * In addition, if the UTF_8 entry is a descriptor, the descriptor has to be rebuilt,
- * all java type having been removed from the descriptor and added to the sting table.
+ * all java type having been removed from the descriptor and added to the string table.
  * eg: "(Ljava/lang/String;I)V" ==> "(L;I)V" and "java/lang", "String"
  * stored in string table. offsets to the 2 strings are compressed and stored in the
  * constantpool entry.