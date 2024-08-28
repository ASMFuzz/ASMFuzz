@@ -2322,7 +2322,7 @@ public void addPreviewInfo(Element forWhat, Content target) {
                 case PACKAGE, MODULE ->
                         ((QualifiedNameable) forWhat).getQualifiedName();
                 case CONSTRUCTOR ->
-                        ((TypeElement) forWhat.getEnclosingElement()).getSimpleName();
+                        forWhat.getEnclosingElement().getSimpleName();
                 default -> forWhat.getSimpleName();
             }).toString();
             var nameCode = HtmlTree.CODE(Text.of(name));