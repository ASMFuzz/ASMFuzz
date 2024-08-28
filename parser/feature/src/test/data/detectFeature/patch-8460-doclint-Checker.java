@@ -214,37 +214,25 @@ public Void scan(DocCommentTree tree, TreePath p) {
         foundReturn = false;
         hasNonWhitespaceText = false;
 
-        switch (p.getLeaf().getKind()) {
+        implicitHeadingRank = switch (p.getLeaf().getKind()) {
             // the following are for declarations that have their own top-level page,
             // and so the doc comment comes after the <h1> page title.
-            case MODULE:
-            case PACKAGE:
-            case CLASS:
-            case INTERFACE:
-            case ENUM:
-            case ANNOTATION_TYPE:
-            case RECORD:
-                implicitHeadingRank = 1;
-                break;
+            case MODULE, PACKAGE, CLASS, INTERFACE, ENUM, ANNOTATION_TYPE, RECORD -> 1;
+
 
             // this is for html files
             // ... if it is a legacy package.html, the doc comment comes after the <h1> page title
             // ... otherwise, (e.g. overview file and doc-files/*.html files) no additional headings are inserted
-            case COMPILATION_UNIT:
-                implicitHeadingRank = fo.isNameCompatible("package", JavaFileObject.Kind.HTML) ? 1 : 0;
-                break;
+            case COMPILATION_UNIT -> fo.isNameCompatible("package", JavaFileObject.Kind.HTML) ? 1 : 0;
+
 
             // the following are for member declarations, which appear in the page
             // for the enclosing type, and so appear after the <h2> "Members"
             // aggregate heading and the specific <h3> "Member signature" heading.
-            case METHOD:
-            case VARIABLE:
-                implicitHeadingRank = 3;
-                break;
+            case METHOD, VARIABLE ->  3;
 
-            default:
-                Assert.error("unexpected tree kind: " + p.getLeaf().getKind() + " " + fo);
-        }
+            default -> throw new AssertionError("unexpected tree kind: " + p.getLeaf().getKind() + " " + fo);
+        };
 
         scan(new DocTreePath(p, tree), null);
 
@@ -259,8 +247,7 @@ public Void scan(DocCommentTree tree, TreePath p) {
                 checkParamsDocumented(ee.getTypeParameters());
                 checkParamsDocumented(ee.getParameters());
                 switch (ee.getReturnType().getKind()) {
-                    case VOID, NONE -> {
-                    }
+                    case VOID, NONE -> { }
                     default -> {
                         if (!foundReturn
                                 && !foundInheritDoc
@@ -387,9 +374,7 @@ public Void visitStartElement(StartElementTree tree, Void ignore) {
             // tag specific checks
             switch (t) {
                 // check for out of sequence headings, such as <h1>...</h1>  <h3>...</h3>
-                case H1: case H2: case H3: case H4: case H5: case H6:
-                    checkHeading(tree, t);
-                    break;
+                case H1, H2, H3, H4, H5, H6 -> checkHeading(tree, t);
             }
 
             if (t.flags.contains(HtmlTag.Flag.NO_NEST)) {
@@ -401,7 +386,7 @@ public Void visitStartElement(StartElementTree tree, Void ignore) {
                 }
             }
 
-            // check for self closing tags, such as <a id="name"/>
+            // check for self-closing tags, such as <a id="name"/>
             if (tree.isSelfClosing() && !isSelfClosingAllowed(t)) {
                 env.messages.error(HTML, tree, "dc.tag.self.closing", treeName);
             }
@@ -417,21 +402,21 @@ public Void visitStartElement(StartElementTree tree, Void ignore) {
             // handle attributes that may or may not have been found in start element
             if (t != null) {
                 switch (t) {
-                    case CAPTION:
+                    case CAPTION -> {
                         if (parent != null && parent.tag == HtmlTag.TABLE)
                             parent.flags.add(Flag.TABLE_HAS_CAPTION);
-                        break;
+                    }
 
-                    case H1: case H2: case H3: case H4: case H5: case H6:
+                    case H1, H2, H3, H4, H5, H6 -> {
                         if (parent != null && (parent.tag == HtmlTag.SECTION || parent.tag == HtmlTag.ARTICLE)) {
                             parent.flags.add(Flag.HAS_HEADING);
                         }
-                        break;
+                    }
 
-                    case IMG:
+                    case IMG -> {
                         if (!top.attrs.contains(HtmlTag.Attr.ALT))
                             env.messages.error(ACCESSIBILITY, tree, "dc.no.alt.attr.for.image");
-                        break;
+                    }
                 }
             }
 
@@ -453,58 +438,56 @@ private void checkStructure(StartElementTree tree, HtmlTag t) {
         Name treeName = tree.getName();
         TagStackItem top = tagStack.peek();
         switch (t.blockType) {
-            case BLOCK:
+            case BLOCK -> {
                 if (top == null || top.tag.accepts(t))
                     return;
 
                 switch (top.tree.getKind()) {
-                    case START_ELEMENT: {
+                    case START_ELEMENT -> {
                         if (top.tag.blockType == HtmlTag.BlockType.INLINE) {
                             Name name = ((StartElementTree) top.tree).getName();
                             env.messages.error(HTML, tree, "dc.tag.not.allowed.inline.element",
                                     treeName, name);
                             return;
                         }
                     }
-                    break;
 
-                    case LINK:
-                    case LINK_PLAIN: {
+                    case LINK, LINK_PLAIN -> {
                         String name = top.tree.getKind().tagName;
                         env.messages.error(HTML, tree, "dc.tag.not.allowed.inline.tag",
                                 treeName, name);
                         return;
                     }
                 }
-                break;
+            }
 
-            case INLINE:
+            case INLINE -> {
                 if (top == null || top.tag.accepts(t))
                     return;
-                break;
+            }
 
-            case LIST_ITEM:
-            case TABLE_ITEM:
+            case LIST_ITEM, TABLE_ITEM -> {
                 if (top != null) {
                     // reset this flag so subsequent bad inline content gets reported
                     top.flags.remove(Flag.REPORTED_BAD_INLINE);
                     if (top.tag.accepts(t))
                         return;
                 }
-                break;
+            }
 
-            case OTHER:
+            case OTHER -> {
                 switch (t) {
-                    case SCRIPT:
-                        // <script> may or may not be allowed, depending on --allow-script-in-comments
+                    case SCRIPT -> {
+                        // <script> may or may not be allowed, depending on --allow-script-in-comments,
                         // but we allow it here, and rely on a separate scanner to detect all uses
                         // of JavaScript, including <script> tags, and use in attributes, etc.
-                        break;
+                    }
 
-                    default:
+                    default ->
                         env.messages.error(HTML, tree, "dc.tag.not.allowed", treeName);
                 }
                 return;
+            }
         }
 
         env.messages.error(HTML, tree, "dc.tag.not.allowed.here", treeName);
@@ -529,17 +512,17 @@ private void checkHeading(StartElementTree tree, HtmlTag tag) {
     }
 
     private int getHeadingRank(HtmlTag tag) {
-        if (tag == null)
-            return implicitHeadingRank;
-        switch (tag) {
-            case H1: return 1;
-            case H2: return 2;
-            case H3: return 3;
-            case H4: return 4;
-            case H5: return 5;
-            case H6: return 6;
-            default: throw new IllegalArgumentException();
-        }
+        return (tag == null)
+                ? implicitHeadingRank
+                : switch (tag) {
+                        case H1 -> 1;
+                        case H2 -> 2;
+                        case H3 -> 3;
+                        case H4 -> 4;
+                        case H5 -> 5;
+                        case H6 -> 6;
+                        default -> throw new IllegalArgumentException();
+                    };
     }
 
     @Override @DefinedBy(Api.COMPILER_TREE)
@@ -556,21 +539,20 @@ public Void visitEndElement(EndElementTree tree, Void ignore) {
                 TagStackItem top = tagStack.peek();
                 if (t == top.tag) {
                     switch (t) {
-                        case TABLE:
+                        case TABLE -> {
                             if (!top.flags.contains(Flag.TABLE_IS_PRESENTATION)
                                     && !top.attrs.contains(HtmlTag.Attr.SUMMARY)
                                     && !top.flags.contains(Flag.TABLE_HAS_CAPTION)) {
                                 env.messages.error(ACCESSIBILITY, tree,
                                         "dc.no.summary.or.caption.for.table");
                             }
-                            break;
+                        }
 
-                        case SECTION:
-                        case ARTICLE:
+                        case SECTION, ARTICLE -> {
                             if (!top.flags.contains(Flag.HAS_HEADING)) {
                                 env.messages.error(HTML, tree, "dc.tag.requires.heading", treeName);
                             }
-                            break;
+                        }
                     }
                     warnIfEmpty(top, tree);
                     tagStack.pop();
@@ -647,23 +629,22 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
             if (!name.toString().startsWith("on")) {
                 AttrKind k = currTag.getAttrKind(name);
                 switch (k) {
-                    case OK:
-                        break;
-                    case OBSOLETE:
+                    case OK -> { }
+
+                    case OBSOLETE ->
                         env.messages.warning(HTML, tree, "dc.attr.obsolete", name);
-                        break;
-                    case HTML4:
+
+                    case HTML4 ->
                         env.messages.error(HTML, tree, "dc.attr.not.supported.html5", name);
-                        break;
-                    case INVALID:
+
+                    case INVALID ->
                         env.messages.error(HTML, tree, "dc.attr.unknown", name);
-                        break;
                 }
             }
 
             if (attr != null) {
                 switch (attr) {
-                    case ID:
+                    case ID -> {
                         String value = getAttrValue(tree);
                         if (value == null) {
                             env.messages.error(HTML, tree, "dc.anchor.value.missing");
@@ -675,9 +656,9 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
                                 env.messages.error(HTML, tree, "dc.anchor.already.defined", value);
                             }
                         }
-                        break;
+                    }
 
-                    case HREF:
+                    case HREF -> {
                         if (currTag == HtmlTag.A) {
                             String v = getAttrValue(tree);
                             if (v == null || v.isEmpty()) {
@@ -693,9 +674,9 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
                                 }
                             }
                         }
-                        break;
+                    }
 
-                    case VALUE:
+                    case VALUE -> {
                         if (currTag == HtmlTag.LI) {
                             String v = getAttrValue(tree);
                             if (v == null || v.isEmpty()) {
@@ -704,9 +685,9 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
                                 env.messages.error(HTML, tree, "dc.attr.not.number");
                             }
                         }
-                        break;
+                    }
 
-                    case BORDER:
+                    case BORDER -> {
                         if (currTag == HtmlTag.TABLE) {
                             String v = getAttrValue(tree);
                             try {
@@ -726,16 +707,16 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
                                 env.messages.error(HTML, tree, "dc.attr.img.border.not.number", attr);
                             }
                         }
-                        break;
+                    }
 
-                    case ROLE:
+                    case ROLE -> {
                         if (currTag == HtmlTag.TABLE) {
                             String v = getAttrValue(tree);
                             if (Objects.equals(v, "presentation")) {
                                 tagStack.peek().flags.add(Flag.TABLE_IS_PRESENTATION);
                             }
                         }
-                        break;
+                    }
                 }
             }
         }
@@ -747,26 +728,17 @@ public Void visitAttribute(AttributeTree tree, Void ignore) {
 
 
     private boolean checkAnchor(String name) {
-        Element e = getEnclosingPackageOrClass(env.currElement);
-        if (e == null)
-            return true;
-        Set<String> set = foundAnchors.get(e);
-        if (set == null)
-            foundAnchors.put(e, set = new HashSet<>());
-        return set.add(name);
+        var e = getEnclosingPackageOrClass(env.currElement);
+        return e == null || foundAnchors.computeIfAbsent(e, k -> new HashSet<>()).add(name);
     }
 
     private Element getEnclosingPackageOrClass(Element e) {
         while (e != null) {
-            switch (e.getKind()) {
-                case CLASS:
-                case ENUM:
-                case INTERFACE:
-                case PACKAGE:
-                    return e;
-                default:
-                    e = e.getEnclosingElement();
+            if (e.getKind().isDeclaredType() || e.getKind() == ElementKind.PACKAGE) {
+                return e;
             }
+
+            e = e.getEnclosingElement();
         }
         return e;
     }
@@ -777,7 +749,7 @@ private Element getEnclosingPackageOrClass(Element e) {
     private static final Pattern validNumber = Pattern.compile("-?[0-9]+");
 
     // pattern to remove leading {@docRoot}/?
-    private static final Pattern docRoot = Pattern.compile("(?i)(\\{@docRoot *\\}/?)?(.*)");
+    private static final Pattern docRoot = Pattern.compile("(?i)(\\{@docRoot *}/?)?(.*)");
 
     private String getAttrValue(AttributeTree tree) {
         if (tree.getValue() == null)
@@ -798,7 +770,7 @@ private void checkURI(AttributeTree tree, String uri) {
         if (uri.startsWith("javascript:"))
             return;
         try {
-            URI u = new URI(uri);
+            new URI(uri);
         } catch (URISyntaxException e) {
             env.messages.error(HTML, tree, "dc.invalid.uri", uri);
         }
@@ -884,28 +856,26 @@ public Void visitLiteral(LiteralTree tree, Void ignore) {
     }
 
     @Override @DefinedBy(Api.COMPILER_TREE)
-    @SuppressWarnings("fallthrough")
     public Void visitParam(ParamTree tree, Void ignore) {
         boolean typaram = tree.isTypeParameter();
         IdentifierTree nameTree = tree.getName();
         Element paramElement = nameTree != null ? env.trees.getElement(new DocTreePath(getCurrentPath(), nameTree)) : null;
 
         if (paramElement == null) {
             switch (env.currElement.getKind()) {
-                case CLASS: case INTERFACE: {
-                    if (!typaram) {
+                case CLASS, INTERFACE -> {
+                    if (typaram) {
+                        env.messages.error(REFERENCE, nameTree, "dc.param.name.not.found");
+                    } else {
                         env.messages.error(REFERENCE, tree, "dc.invalid.param");
-                        break;
                     }
                 }
-                case METHOD: case CONSTRUCTOR: {
+
+                case METHOD, CONSTRUCTOR, RECORD ->
                     env.messages.error(REFERENCE, nameTree, "dc.param.name.not.found");
-                    break;
-                }
 
-                default:
+                default ->
                     env.messages.error(REFERENCE, tree, "dc.invalid.param");
-                    break;
             }
         } else {
             boolean unique = foundParams.add(paramElement);
@@ -1056,14 +1026,14 @@ public Void visitThrows(ThrowsTree tree, Void ignore) {
             env.messages.error(REFERENCE, tree, "dc.ref.not.found");
         } else if (isThrowable(ex.asType())) {
             switch (env.currElement.getKind()) {
-                case CONSTRUCTOR:
-                case METHOD:
+                case CONSTRUCTOR, METHOD -> {
                     if (isCheckedException(ex.asType())) {
                         ExecutableElement ee = (ExecutableElement) env.currElement;
                         checkThrowsDeclared(exName, ex.asType(), ee.getThrownTypes());
                     }
-                    break;
-                default:
+                }
+
+                default ->
                     env.messages.error(REFERENCE, tree, "dc.invalid.throws");
             }
         } else {
@@ -1074,12 +1044,10 @@ public Void visitThrows(ThrowsTree tree, Void ignore) {
     }
 
     private boolean isThrowable(TypeMirror tm) {
-        switch (tm.getKind()) {
-            case DECLARED:
-            case TYPEVAR:
-                return env.types.isAssignable(tm, env.java_lang_Throwable);
-        }
-        return false;
+        return switch (tm.getKind()) {
+            case DECLARED, TYPEVAR -> env.types.isAssignable(tm, env.java_lang_Throwable);
+            default -> false;
+        };
     }
 
     private void checkThrowsDeclared(ReferenceTree tree, TypeMirror t, List<? extends TypeMirror> list) {
@@ -1153,15 +1121,11 @@ public Void visitValue(ValueTree tree, Void ignore) {
     }
 
     private boolean isConstant(Element e) {
-        if (e == null)
+        if (e != null && e.getKind() == ElementKind.FIELD) {
+            Object value = ((VariableElement) e).getConstantValue();
+            return (value != null); // can't distinguish "not a constant" from "constant is null"
+        } else {
             return false;
-
-        switch (e.getKind()) {
-            case FIELD:
-                Object value = ((VariableElement) e).getConstantValue();
-                return (value != null); // can't distinguish "not a constant" from "constant is null"
-            default:
-                return false;
         }
     }
 
@@ -1199,14 +1163,14 @@ private boolean isAnonymous() {
     }
 
     private boolean isDefaultConstructor() {
-        switch (env.currElement.getKind()) {
-            case CONSTRUCTOR:
-                // A synthetic default constructor has the same pos as the
-                // enclosing class
-                TreePath p = env.currPath;
-                return env.getPos(p) == env.getPos(p.getParentPath());
+        if (env.currElement.getKind() == ElementKind.CONSTRUCTOR) {
+            // A synthetic default constructor has the same pos as the
+            // enclosing class
+            TreePath p = env.currPath;
+            return env.getPos(p) == env.getPos(p.getParentPath());
+        } else {
+            return false;
         }
-        return false;
     }
 
     private boolean isDeclaredType() {
@@ -1243,6 +1207,7 @@ void markEnclosingTag(Flag flag) {
             top.flags.add(flag);
     }
 
+    // for debug use
     String toString(TreePath p) {
         StringBuilder sb = new StringBuilder("TreePath[");
         toString(p, sb);
@@ -1261,13 +1226,9 @@ void toString(TreePath p, StringBuilder sb) {
 
     void warnIfEmpty(DocTree tree, List<? extends DocTree> list) {
         for (DocTree d: list) {
-            switch (d.getKind()) {
-                case TEXT:
-                    if (hasNonWhitespace((TextTree) d))
-                        return;
-                    break;
-                default:
-                    return;
+            if (d.getKind() != DocTree.Kind.TEXT
+                    || hasNonWhitespace((TextTree) d)) {
+                return;
             }
         }
         env.messages.warning(MISSING, tree, "dc.empty", tree.getKind().tagName);