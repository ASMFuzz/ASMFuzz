@@ -29,7 +29,7 @@
  * @compile package-info.java
  * @run main/othervm T6257443 -yes foo/package-info.class
  *
- * @clean foo.package-info
+ * @clean foo.*
  *
  * @compile -printsource package-info.java
  * @run main/othervm T6257443 -no foo/package-info.class