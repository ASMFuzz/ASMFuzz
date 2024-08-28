@@ -573,7 +573,7 @@ private static Collection<String> getSubjectAltNames(
                     if ((subAltDnsName != null) && !subAltDnsName.isEmpty()) {
                         if (subAltDnsNames == null) {
                             subAltDnsNames =
-                                    new HashSet<>(subjectAltNames.size());
+                                    HashSet.newHashSet(subjectAltNames.size());
                         }
                         subAltDnsNames.add(subAltDnsName);
                     }