@@ -1043,6 +1043,14 @@ public String toString() {
                         buf.append(tsym.packge());
                         buf.append(".");
                     }
+                    ListBuffer<Name> names = new ListBuffer<>();
+                    for (Symbol sym = tsym.owner; sym != null && sym.kind == TYP; sym = sym.owner) {
+                        names.prepend(sym.name);
+                    }
+                    for (Name name : names) {
+                        buf.append(name);
+                        buf.append(".");
+                    }
                     appendAnnotationsString(buf);
                     buf.append(tsym.name);
                 } else {