@@ -36,8 +36,8 @@
  * <p> This language model follows a <i>mirror</i>-based design; see
  *
  * <blockquote>
- * Gilad Bracha and David Ungar. <i>Mirrors: Design Principles for
- * Meta-level Facilities of Object-Oriented Programming Languages</i>.
+ * Gilad Bracha and David Ungar. <cite>Mirrors: Design Principles for
+ * Meta-level Facilities of Object-Oriented Programming Languages</cite>.
  * In Proc. of the ACM Conf. on Object-Oriented Programming, Systems,
  * Languages and Applications, October 2004.
  * </blockquote>
@@ -53,6 +53,9 @@
  * a {@code NullPointerException} if given a {@code null} argument.
  *
  * @since 1.6
+ *
+ * @see <a href="https://jcp.org/en/jsr/detail?id=269">
+ * JSR 269: Pluggable Annotation Processing API</a>
  */
 
 package javax.lang.model;