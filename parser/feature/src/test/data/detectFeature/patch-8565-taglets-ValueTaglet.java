@@ -26,10 +26,14 @@
 package jdk.javadoc.internal.doclets.toolkit.taglets;
 
 import java.util.EnumSet;
+import java.util.IllegalFormatException;
+import java.util.Optional;
 import javax.lang.model.element.Element;
 import javax.lang.model.element.VariableElement;
 
 import com.sun.source.doctree.DocTree;
+import com.sun.source.doctree.TextTree;
+import com.sun.source.doctree.ValueTree;
 import jdk.javadoc.doclet.Taglet.Location;
 import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;
 import jdk.javadoc.internal.doclets.toolkit.Content;
@@ -95,8 +99,27 @@ public Content getInlineTagOutput(Element holder, DocTree tag, TagletWriter writ
                         "doclet.value_tag_invalid_reference", tag.toString());
             }
         } else if (field.getConstantValue() != null) {
+            TextTree format = ((ValueTree) tag).getFormat();
+            String text;
+            if (format != null) {
+                String f = format.getBody();
+                if (f.startsWith("\"")) {
+                    f = f.substring(1, f.length() - 1);
+                }
+                try {
+                    text = String.format(configuration.getLocale(), f, field.getConstantValue());
+                } catch (IllegalFormatException e) {
+                    messages.error(holder,
+                            "doclet.value_tag_invalid_format", format);
+                    return writer.invalidTagOutput(
+                            messages.getResources().getText("doclet.value_tag_invalid_format", format),
+                            Optional.empty());
+                }
+            } else {
+                text = utils.constantValueExpression(field);
+            }
             return writer.valueTagOutput(field,
-                utils.constantValueExpression(field),
+                text,
                 // TODO: investigate and cleanup
                 // in the j.l.m world, equals will not be accurate
                 // !field.equals(tag.holder())