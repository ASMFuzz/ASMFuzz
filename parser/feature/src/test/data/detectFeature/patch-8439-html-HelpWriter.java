@@ -390,6 +390,15 @@ private Content getPageKindSection(HtmlTree mainTOC) {
             pageKindsSection.add(section);
         }
 
+        // External Specification
+        if (configuration.conditionalPages.contains(HtmlConfiguration.ConditionalPage.EXTERNAL_SPECS)) {
+            section = newHelpSection(contents.externalSpecifications, PageMode.EXTERNAL_SPECS, subTOC);
+            Content extSpecsBody = getContent("doclet.help.externalSpecifications.body",
+                    links.createLink(DocPaths.EXTERNAL_SPECS, resources.getText("doclet.External_Specifications")));
+            section.add(HtmlTree.P(extSpecsBody));
+            pageKindsSection.add(section);
+        }
+
         // Index
         if (options.createIndex()) {
             if (!configuration.packages.isEmpty()) {