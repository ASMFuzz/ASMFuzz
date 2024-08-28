@@ -95,6 +95,7 @@ public class Contents {
     public final Content exceptionClass;
     public final Content exceptionClasses;
     public final Content exportedTo;
+    public final Content externalSpecifications;
     public final Content fieldLabel;
     public final Content fieldDetailsLabel;
     public final Content fieldSummaryLabel;
@@ -169,6 +170,7 @@ public class Contents {
     public final Content seeAlso;
     public final Content serializedForm;
     public final Content servicesLabel;
+    public final Content specificationLabel;
     public final Content specifiedByLabel;
     public final Content subclassesLabel;
     public final Content subinterfacesLabel;
@@ -239,6 +241,7 @@ public class Contents {
         exceptionClass = getContent("doclet.ExceptionClass");
         exceptionClasses = getContent("doclet.ExceptionClasses");
         exportedTo = getContent("doclet.ExportedTo");
+        externalSpecifications = getContent("doclet.External_Specifications");
         fieldDetailsLabel = getContent("doclet.Field_Detail");
         fieldSummaryLabel = getContent("doclet.Field_Summary");
         fieldLabel = getContent("doclet.Field");
@@ -313,6 +316,7 @@ public class Contents {
         seeAlso = getContent("doclet.See_Also");
         serializedForm = getContent("doclet.Serialized_Form");
         servicesLabel = getContent("doclet.Services");
+        specificationLabel = getContent("doclet.Specification");
         specifiedByLabel = getContent("doclet.Specified_By");
         subclassesLabel = getContent("doclet.Subclasses");
         subinterfacesLabel = getContent("doclet.Subinterfaces");