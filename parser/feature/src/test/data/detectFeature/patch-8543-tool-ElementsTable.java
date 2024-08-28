@@ -239,12 +239,10 @@ public class ElementsTable {
      * @return the module documentation level mode
      */
     public ModuleMode getModuleMode() {
-        switch(accessFilter.getAccessValue(ElementKind.MODULE)) {
-            case PACKAGE: case PRIVATE:
-                return DocletEnvironment.ModuleMode.ALL;
-            default:
-                return DocletEnvironment.ModuleMode.API;
-        }
+        return switch (accessFilter.getAccessValue(ElementKind.MODULE)) {
+            case PACKAGE, PRIVATE -> ModuleMode.ALL;
+            default -> ModuleMode.API;
+        };
     }
 
     private Set<Element> specifiedElements = null;
@@ -272,7 +270,7 @@ public Set<? extends Element> getSpecifiedElements() {
      * A module is fully included,
      *   - is specified on the command line --module
      *   - is derived from the module graph, that is, by expanding the
-     *     requires directive, based on --expand-requires
+     *     'requires' directive, based on --expand-requires
      *
      * A module is included if an enclosed package or type is
      * specified on the command line.
@@ -653,7 +651,7 @@ private Set<PackageElement> getAllModulePackages(ModuleElement mdle) throws Tool
                 String binaryName = fm.inferBinaryName(msymloc, fo);
                 String pn = getPackageName(binaryName);
                 PackageSymbol psym = syms.enterPackage(msym, names.fromString(pn));
-                result.add((PackageElement) psym);
+                result.add(psym);
             }
         }
         return result;
@@ -993,7 +991,7 @@ public boolean isSelected(Element e) {
             return false;
         }
         if (visibleElementVisitor == null) {
-            visibleElementVisitor = new SimpleElementVisitor14<Boolean, Void>() {
+            visibleElementVisitor = new SimpleElementVisitor14<>() {
                 @Override
                 public Boolean visitType(TypeElement e, Void p) {
                     if (!accessFilter.checkModifier(e)) {
@@ -1061,14 +1059,11 @@ public Boolean visitType(TypeElement e, Void p) {
                 }
                 Element enclosing = e.getEnclosingElement();
                 if (enclosing != null) {
-                    switch(enclosing.getKind()) {
-                        case PACKAGE:
-                            return specifiedPackageElements.contains((PackageElement)enclosing);
-                        case CLASS: case INTERFACE: case ENUM: case ANNOTATION_TYPE:
-                            return visit((TypeElement) enclosing);
-                        default:
-                            throw new AssertionError("unknown element: " + enclosing);
-                    }
+                    return switch (enclosing.getKind()) {
+                        case CLASS, ENUM, RECORD, INTERFACE, ANNOTATION_TYPE -> visit(enclosing);
+                        case PACKAGE -> specifiedPackageElements.contains((PackageElement) enclosing);
+                        default -> throw new AssertionError("unknown element: " + enclosing);
+                    };
                 }
             }
             return false;
@@ -1080,14 +1075,14 @@ public Boolean defaultAction(Element e, Void p) {
             if (includedCache.contains(e))
                 return true;
             if (visit(e.getEnclosingElement()) && isSelected(e)) {
-                switch(e.getKind()) {
-                    case ANNOTATION_TYPE: case CLASS: case ENUM: case INTERFACE:
-                    case MODULE: case OTHER: case PACKAGE:
-                        throw new AssertionError("invalid element for this operation: " + e);
-                    default:
+                switch (e.getKind()) {
+                    case CLASS, ENUM, RECORD, INTERFACE, ANNOTATION_TYPE,
+                            MODULE, OTHER, PACKAGE -> throw new AssertionError("invalid element for this operation: " + e);
+                    default -> {
                         // the only allowed kinds in the cache are "members"
                         includedCache.add(e);
                         return true;
+                    }
                 }
             }
             return false;
@@ -1208,40 +1203,25 @@ static class ModifierFilter {
 
             AccessKind accessValue = null;
             for (ElementKind kind : ALLOWED_KINDS) {
-                switch (kind) {
-                    case METHOD:
-                        accessValue  = options.showMembersAccess();
-                        break;
-                    case CLASS:
-                        accessValue  = options.showTypesAccess();
-                        break;
-                    case PACKAGE:
-                        accessValue  = options.showPackagesAccess();
-                        break;
-                    case MODULE:
-                        accessValue  = options.showModuleContents();
-                        break;
-                    default:
-                        throw new AssertionError("unknown element: " + kind);
-
-                }
+                accessValue = switch (kind) {
+                    case METHOD  -> options.showMembersAccess();
+                    case CLASS   -> options.showTypesAccess();
+                    case PACKAGE -> options.showPackagesAccess();
+                    case MODULE  -> options.showModuleContents();
+                    default -> throw new AssertionError("unknown element: " + kind);
+                };
                 accessMap.put(kind, accessValue);
                 filterMap.put(kind, getFilterSet(accessValue));
             }
         }
 
         static EnumSet<AccessKind> getFilterSet(AccessKind accessValue) {
-            switch (accessValue) {
-                case PUBLIC:
-                    return EnumSet.of(AccessKind.PUBLIC);
-                case PROTECTED:
-                default:
-                    return EnumSet.of(AccessKind.PUBLIC, AccessKind.PROTECTED);
-                case PACKAGE:
-                    return EnumSet.of(AccessKind.PUBLIC, AccessKind.PROTECTED, AccessKind.PACKAGE);
-                case PRIVATE:
-                    return EnumSet.allOf(AccessKind.class);
-            }
+            return switch (accessValue) {
+                case PUBLIC    -> EnumSet.of(AccessKind.PUBLIC);
+                case PROTECTED -> EnumSet.of(AccessKind.PUBLIC, AccessKind.PROTECTED);
+                case PACKAGE   -> EnumSet.of(AccessKind.PUBLIC, AccessKind.PROTECTED, AccessKind.PACKAGE);
+                case PRIVATE   -> EnumSet.allOf(AccessKind.class);
+            };
         }
 
         public AccessKind getAccessValue(ElementKind kind) {
@@ -1273,19 +1253,13 @@ public boolean checkModifier(Element e) {
 
         // convert a requested element kind to an allowed access kind
         private ElementKind getAllowedKind(ElementKind kind) {
-            switch (kind) {
-                case CLASS: case METHOD: case MODULE: case PACKAGE:
-                    return kind;
-                case RECORD: case ANNOTATION_TYPE: case ENUM: case INTERFACE:
-                    return ElementKind.CLASS;
-                case CONSTRUCTOR: case ENUM_CONSTANT: case EXCEPTION_PARAMETER:
-                case FIELD: case INSTANCE_INIT: case LOCAL_VARIABLE: case PARAMETER:
-                case RESOURCE_VARIABLE: case STATIC_INIT: case TYPE_PARAMETER:
-                case RECORD_COMPONENT:
-                    return ElementKind.METHOD;
-                default:
-                    throw new AssertionError("unsupported kind: " + kind);
-            }
+            return switch (kind) {
+                case CLASS, METHOD, MODULE, PACKAGE -> kind;
+                case RECORD, ANNOTATION_TYPE, ENUM, INTERFACE -> ElementKind.CLASS;
+                case CONSTRUCTOR, ENUM_CONSTANT, EXCEPTION_PARAMETER, FIELD, INSTANCE_INIT, LOCAL_VARIABLE,
+                        PARAMETER, RESOURCE_VARIABLE, STATIC_INIT, TYPE_PARAMETER, RECORD_COMPONENT -> ElementKind.METHOD;
+                default -> throw new AssertionError("unsupported kind: " + kind);
+            };
         }
     } // end ModifierFilter
 }