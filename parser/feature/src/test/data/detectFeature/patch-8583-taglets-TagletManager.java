@@ -381,9 +381,15 @@ public void checkTags(Element element, Iterable<? extends DocTree> trees, boolea
             final Taglet taglet = allTaglets.get(name);
             // Check and verify tag usage
             if (taglet != null) {
+                if (taglet instanceof SimpleTaglet st && !st.enabled) {
+                    // taglet has been disabled
+                    return;
+                }
+
                 if (inlineTrees && !taglet.isInlineTag()) {
                     printTagMisuseWarn(ch, taglet, tag, "inline");
                 }
+
                 // nothing more to do
                 if (element == null) {
                     return;