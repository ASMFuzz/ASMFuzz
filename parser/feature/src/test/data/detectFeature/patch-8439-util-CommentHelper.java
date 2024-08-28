@@ -25,28 +25,12 @@
 
 package jdk.javadoc.internal.doclets.toolkit.util;
 
-import java.util.List;
-import java.util.stream.Collectors;
-
-import javax.lang.model.element.Element;
-import javax.lang.model.element.ElementKind;
-import javax.lang.model.element.ExecutableElement;
-import javax.lang.model.element.ModuleElement;
-import javax.lang.model.element.PackageElement;
-import javax.lang.model.element.TypeElement;
-import javax.lang.model.type.TypeKind;
-import javax.lang.model.type.TypeMirror;
-
-import com.sun.source.doctree.AttributeTree;
-import com.sun.source.doctree.AttributeTree.ValueKind;
 import com.sun.source.doctree.AuthorTree;
 import com.sun.source.doctree.BlockTagTree;
 import com.sun.source.doctree.CommentTree;
 import com.sun.source.doctree.DeprecatedTree;
 import com.sun.source.doctree.DocCommentTree;
 import com.sun.source.doctree.DocTree;
-import com.sun.source.doctree.EndElementTree;
-import com.sun.source.doctree.EntityTree;
 import com.sun.source.doctree.IdentifierTree;
 import com.sun.source.doctree.InlineTagTree;
 import com.sun.source.doctree.LinkTree;
@@ -60,7 +44,7 @@
 import com.sun.source.doctree.SerialFieldTree;
 import com.sun.source.doctree.SerialTree;
 import com.sun.source.doctree.SinceTree;
-import com.sun.source.doctree.StartElementTree;
+import com.sun.source.doctree.SpecTree;
 import com.sun.source.doctree.TextTree;
 import com.sun.source.doctree.ThrowsTree;
 import com.sun.source.doctree.UnknownBlockTagTree;
@@ -73,7 +57,18 @@
 import com.sun.source.util.TreePath;
 import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;
 
-import static com.sun.source.doctree.DocTree.Kind.*;
+import javax.lang.model.element.Element;
+import javax.lang.model.element.ElementKind;
+import javax.lang.model.element.ExecutableElement;
+import javax.lang.model.element.ModuleElement;
+import javax.lang.model.element.PackageElement;
+import javax.lang.model.element.TypeElement;
+import javax.lang.model.type.TypeKind;
+import javax.lang.model.type.TypeMirror;
+import java.util.List;
+
+import static com.sun.source.doctree.DocTree.Kind.SEE;
+import static com.sun.source.doctree.DocTree.Kind.SERIAL_FIELD;
 
 /**
  * A utility class.
@@ -482,6 +477,11 @@ public List<? extends DocTree> visitSerialField(SerialFieldTree node, Void p) {
                 return node.getDescription();
             }
 
+            @Override
+            public List<? extends DocTree> visitSpec(SpecTree node, Void p) {
+                return node.getTitle();
+            }
+
             @Override
             public List<? extends DocTree> visitThrows(ThrowsTree node, Void p) {
                 return node.getDescription();