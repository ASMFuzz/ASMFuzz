@@ -74,7 +74,7 @@
  *
  * <blockquote><pre>
  * NumberFormat fmt = NumberFormat.getCompactNumberInstance(
- *                             new Locale("hi", "IN"), NumberFormat.Style.SHORT);
+ *                             Locale.forLanguageTag("hi-IN"), NumberFormat.Style.SHORT);
  * String result = fmt.format(1000);
  * </pre></blockquote>
  *