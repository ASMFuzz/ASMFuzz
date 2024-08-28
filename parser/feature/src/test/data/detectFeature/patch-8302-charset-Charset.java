@@ -718,7 +718,7 @@ public final Set<String> aliases() {
         if (aliasSet != null)
             return aliasSet;
         int n = aliases.length;
-        HashSet<String> hs = new HashSet<>(n);
+        HashSet<String> hs = HashSet.newHashSet(n);
         for (int i = 0; i < n; i++)
             hs.add(aliases[i]);
         aliasSet = Collections.unmodifiableSet(hs);