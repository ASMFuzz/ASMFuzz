@@ -123,7 +123,7 @@ public final class DecimalStyle {
      */
     public static Set<Locale> getAvailableLocales() {
         Locale[] l = DecimalFormatSymbols.getAvailableLocales();
-        Set<Locale> locales = new HashSet<>(l.length);
+        Set<Locale> locales = HashSet.newHashSet(l.length);
         Collections.addAll(locales, l);
         return locales;
     }