@@ -62,6 +62,22 @@ public void setPath(String cgroupPath) {
                             String cgroupSubstr = cgroupPath.substring(root.length());
                             path = mountPoint + cgroupSubstr;
                         }
+                    } else {
+                        StringBuilder pathBuilder = new StringBuilder();
+                        pathBuilder.append(mountPoint);
+                        // Find the longest commonly shared path
+                        String[] rTokens = root.split("/");
+                        String[] cTokens = cgroupPath.split("/");
+                        for (int i = 0; rTokens[i].equals(cTokens[i]); i++) {
+                            // "/foo".split() ==> [ "", "foo" ]. Therefore, skip empty
+                            // tokens
+                            if (rTokens[i].isEmpty() && cTokens[i].isEmpty()) {
+                                continue;
+                            }
+                            pathBuilder.append("/");
+                            pathBuilder.append(rTokens[i]);
+                        }
+                        path = pathBuilder.toString();
                     }
                 }
             }