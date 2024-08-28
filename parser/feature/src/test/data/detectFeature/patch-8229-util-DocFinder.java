@@ -41,87 +41,67 @@
  */
 public class DocFinder {
 
-    public static final class DocTreeInfo {
-        public final DocTree docTree;
-        public final Element element;
-
-        public DocTreeInfo() {
-            this.docTree = null;
-            this.element = null;
-        }
-
-        public DocTreeInfo(DocTree docTree, Element baseElement) {
-            this.docTree = docTree;
-            this.element = baseElement;
-        }
-
-        @Override
-        public String toString() {
-            return "DocTreeInfo{" + "docTree=" + docTree + ", element=" + element + '}';
-        }
-    }
+    public record DocTreeInfo(DocTree docTree, Element element) { }
 
     /**
      * The class that encapsulates the input.
      */
     public static class Input {
+
         /**
          * The element to search documentation from.
          */
         public Element element;
+
         /**
          * The taglet to search for documentation on behalf of. Null if we want
          * to search for overall documentation.
          */
-        public InheritableTaglet taglet = null;
+        public InheritableTaglet taglet;
 
         /**
          * The id of the tag to retrieve documentation for.
          */
-        public String tagId = null;
+        public String tagId;
 
         /**
          * The tag to retrieve documentation for.  This is only used for the
-         * inheritDoc tag.
+         * {@code {@inheritDoc}} tag.
          */
         public final DocTreeInfo docTreeInfo;
 
         /**
          * True if we only want to search for the first sentence.
          */
-        public boolean isFirstSentence = false;
+        public boolean isFirstSentence;
 
         /**
-         * True if we are looking for documentation to replace the inheritDocTag.
+         * True if we are looking for documentation to replace the {@code {@inheritDoc}} tag.
          */
-        public boolean isInheritDocTag = false;
+        public boolean isInheritDocTag;
 
         /**
          * Used to distinguish between type variable param tags and regular
          * param tags.
          */
-        public boolean isTypeVariableParamTag = false;
+        public boolean isTypeVariableParamTag;
 
         public final Utils utils;
 
-        public Input(Utils utils, Element element, InheritableTaglet taglet, DocTreeInfo dtInfo,
-                boolean isFirstSentence, boolean isInheritDocTag) {
-            this.utils = utils;
-            this.element = element;
-            this.taglet = taglet;
-            this.isFirstSentence = isFirstSentence;
-            this.isInheritDocTag = isInheritDocTag;
-            this.docTreeInfo = dtInfo;
-        }
-
-        public Input(Utils utils, Element element, InheritableTaglet taglet, String tagId) {
+        public Input(Utils utils,
+                     Element element,
+                     InheritableTaglet taglet,
+                     String tagId) {
             this(utils, element);
             this.taglet = taglet;
             this.tagId = tagId;
         }
 
-        public Input(Utils utils, Element element, InheritableTaglet taglet, String tagId,
-            boolean isTypeVariableParamTag) {
+        public Input(Utils utils,
+                     Element element,
+                     InheritableTaglet taglet,
+                     String tagId,
+                     boolean isTypeVariableParamTag) {
             this(utils, element);
             this.taglet = taglet;
             this.tagId = tagId;
@@ -134,32 +114,35 @@ public Input(Utils utils, Element element, InheritableTaglet taglet) {
         }
 
         public Input(Utils utils, Element element) {
-            if (element == null)
-                throw new NullPointerException();
-            this.element = element;
+            this.element = Objects.requireNonNull(element);
             this.utils = utils;
-            this.docTreeInfo = new DocTreeInfo();
+            this.docTreeInfo = new DocTreeInfo(null, null);
         }
 
-        public Input(Utils utils, Element element, boolean isFirstSentence) {
-            this(utils, element);
+        public Input(Utils utils,
+                     Element element,
+                     InheritableTaglet taglet,
+                     DocTreeInfo dtInfo,
+                     boolean isFirstSentence,
+                     boolean isInheritDocTag) {
+            this.utils = utils;
+            this.element = Objects.requireNonNull(element);
+            this.taglet = taglet;
             this.isFirstSentence = isFirstSentence;
+            this.isInheritDocTag = isInheritDocTag;
+            this.docTreeInfo = dtInfo;
         }
 
-        public Input copy(Utils utils) {
-            if (this.element == null) {
-                throw new NullPointerException();
-            }
-            Input clone = new Input(utils, this.element, this.taglet, this.docTreeInfo,
-                    this.isFirstSentence, this.isInheritDocTag);
-            clone.tagId = this.tagId;
-            clone.isTypeVariableParamTag = this.isTypeVariableParamTag;
-            return clone;
+        private Input copy() {
+            var copy = new Input(utils, element, taglet, docTreeInfo,
+                    isFirstSentence, isInheritDocTag);
+            copy.tagId = tagId;
+            copy.isTypeVariableParamTag = isTypeVariableParamTag;
+            return copy;
         }
 
         /**
-         * For debugging purposes
-         * @return string representation
+         * For debugging purposes.
          */
         @Override
         public String toString() {
@@ -178,14 +161,15 @@ public String toString() {
      * The class that encapsulates the output.
      */
     public static class Output {
+
         /**
          * The tag that holds the documentation.  Null if documentation
          * is not held by a tag.
          */
         public DocTree holderTag;
 
         /**
-         * The Doc object that holds the documentation.
+         * The element that holds the documentation.
          */
         public Element holder;
 
@@ -200,18 +184,16 @@ public static class Output {
         public boolean isValidInheritDocTag = true;
 
         /**
-         * When automatically inheriting throws tags, you sometime must inherit
-         * more than one tag.  For example if the element declares that it throws
-         * IOException and the overridden element has throws tags for IOException and
+         * When automatically inheriting throws tags, you sometimes must inherit
+         * more than one tag.  For example, if a method declares that it throws
+         * IOException and the overridden method has {@code @throws} tags for IOException and
          * ZipException, both tags would be inherited because ZipException is a
-         * subclass of IOException.  This subclass of DocFinder.Output allows
-         * multiple tag inheritance.
+         * subclass of IOException.  This allows multiple tag inheritance.
          */
-        public List<DocTree> tagList  = new ArrayList<>();
+        public final List<DocTree> tagList = new ArrayList<>();
 
         /**
-         * Returns a string representation for debugging purposes
-         * @return string
+         * For debugging purposes.
          */
         @Override
         public String toString() {
@@ -226,9 +208,7 @@ public String toString() {
 
     /**
      * Search for the requested comments in the given element.  If it does not
-     * have comments, return documentation from the overridden element if possible.
-     * If the overridden element does not exist or does not have documentation to
-     * inherit, search for documentation to inherit from implemented methods.
+     * have comments, return the inherited comments if possible.
      *
      * @param input the input object used to perform the search.
      *
@@ -250,14 +230,15 @@ public static Output search(BaseConfiguration configuration, Input input) {
             input.taglet.inherit(input, output);
         }
 
-        if (output.inlineTags != null && !output.inlineTags.isEmpty()) {
+        if (!output.inlineTags.isEmpty()) {
             return output;
         }
         output.isValidInheritDocTag = false;
-        Input inheritedSearchInput = input.copy(configuration.utils);
+        Input inheritedSearchInput = input.copy();
         inheritedSearchInput.isInheritDocTag = false;
         if (utils.isMethod(input.element)) {
-            ExecutableElement overriddenMethod = utils.overriddenMethod((ExecutableElement) input.element);
+            ExecutableElement m = (ExecutableElement) input.element;
+            ExecutableElement overriddenMethod = utils.overriddenMethod(m);
             if (overriddenMethod != null) {
                 inheritedSearchInput.element = overriddenMethod;
                 output = search(configuration, inheritedSearchInput);
@@ -266,13 +247,9 @@ public static Output search(BaseConfiguration configuration, Input input) {
                     return output;
                 }
             }
-            //NOTE:  When we fix the bug where ClassDoc.interfaceTypes() does
-            //       not pass all implemented interfaces, we will use the
-            //       appropriate element here.
             TypeElement encl = utils.getEnclosingTypeElement(input.element);
             VisibleMemberTable vmt = configuration.getVisibleMemberTable(encl);
-            List<ExecutableElement> implementedMethods =
-                    vmt.getImplementedMethods((ExecutableElement)input.element);
+            List<ExecutableElement> implementedMethods = vmt.getImplementedMethods(m);
             for (ExecutableElement implementedMethod : implementedMethods) {
                 inheritedSearchInput.element = implementedMethod;
                 output = search(configuration, inheritedSearchInput);