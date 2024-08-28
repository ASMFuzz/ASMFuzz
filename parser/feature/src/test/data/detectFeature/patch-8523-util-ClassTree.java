@@ -27,11 +27,10 @@
 
 
 import java.util.ArrayList;
-import java.util.Collection;
 import java.util.Collections;
 import java.util.Comparator;
+import java.util.EnumMap;
 import java.util.HashMap;
-import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
@@ -42,233 +41,267 @@
 import javax.lang.model.element.TypeElement;
 import javax.lang.model.type.TypeMirror;
 
-import jdk.javadoc.doclet.DocletEnvironment;
 import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;
 import jdk.javadoc.internal.doclets.toolkit.Messages;
 
 /**
- * Build Class Hierarchy for all the Classes. This class builds the Class
- * Tree and the Interface Tree separately.
+ * Class and interface hierarchies.
  */
 public class ClassTree {
 
     /**
-     * List of base classes. Used to get the mapped listing of sub-classes.
+     * The kind of hierarchy.
+     * Currently, the kinds correspond to the kinds of declared types,
+     * although other partitions could be possible.
      */
-    private final SortedSet<TypeElement> baseClasses;
+    private enum HierarchyKind {
+        CLASSES, ENUM_CLASSES, RECORD_CLASSES, INTERFACES, ANNOTATION_INTERFACES
+    }
 
     /**
-     * Mapping for each Class with their sub classes
+     * A "hierarchy" provides the subtypes of all the supertypes of a set of leaf elements,
+     * together with the root supertype(s).
      */
-    private final Map<TypeElement, SortedSet<TypeElement>> subClasses = new HashMap<>();
+    public static class Hierarchy {
+        private final SortedSet<TypeElement> roots;
+        private final SubtypeMap subtypes;
+        private final Comparator<Element> comparator;
+
+        Hierarchy(Comparator<Element> comparator) {
+            this.comparator = comparator;
+            roots = new TreeSet<>(comparator);
+            subtypes = new SubtypeMap(comparator);
+        }
+
+        /**
+         * {@return the roots of the hierarchy}
+         * Each root is a class or interface with no superclass or superinterfaces.
+         * If the hierarchy just contains classes, the root will be {@code java.lang.Object}.
+         */
+        public SortedSet<TypeElement> roots() {
+            return roots;
+        }
+
+        /**
+         * {@return the immediate subtypes of the given type element, or an empty set if there are none}
+         * @param typeElement the type element
+         */
+        public SortedSet<TypeElement> subtypes(TypeElement typeElement) {
+            return subtypes.getOrDefault(typeElement, Collections.emptySortedSet());
+        }
+
+        /**
+         * {@return the set of all subtypes of the given type element, or an empty set if there are none}
+         *
+         * The set of all subtypes is the transitive closure of the {@linkplain #subtypes(TypeElement) immediate subtypes}
+         * of the given type element.
+         *
+         * @param typeElement the type element
+         */
+        public SortedSet<TypeElement> allSubtypes(TypeElement typeElement) {
+            // new entries added to the collection are searched as well;
+            // this is really a work queue.
+            List<TypeElement> list = new ArrayList<>(subtypes(typeElement));
+            for (int i = 0; i < list.size(); i++) {
+                var subtypes = subtypes(list.get(i));
+                for (var subtype : subtypes) {
+                    if (!list.contains(subtype)) {
+                        list.add(subtype);
+                    }
+                }
+            }
+            SortedSet<TypeElement> out = new TreeSet<>(comparator);
+            out.addAll(list);
+            return out;
+        }
+    }
 
     /**
-     * List of base-interfaces. Contains set of all the interfaces who do not
-     * have super-interfaces. Can be used to get the mapped listing of
-     * sub-interfaces.
+     * A map giving the subtypes for each of a collection of type elements.
+     * The subtypes may be subclasses or subinterfaces, depending on the context.
+     *
+     * The subtypes are recorded by calling {@link SubtypeMap#addSubtype(TypeElement, TypeElement) addSubtype}.
      */
-    private final SortedSet<TypeElement> baseInterfaces;
+    @SuppressWarnings("serial")
+    private static class SubtypeMap extends HashMap<TypeElement, SortedSet<TypeElement>> {
+        private final Comparator<Element> comparator;
+
+        /**
+         * Creates a map to provide the subtypes of a type element,
+         * sorted according to a given comparator.
+         *
+         * An alternate implementation would be to store the subtypes unsorted,
+         * and to lazily sort them when needed, such as when generating documentation.
+         *
+         * @param comparator the comparator
+         */
+        SubtypeMap(Comparator<Element> comparator) {
+            this.comparator = comparator;
+        }
 
-   /**
-    * Mapping for each Interface with their SubInterfaces
-    */
-    private final Map<TypeElement, SortedSet<TypeElement>> subInterfaces = new HashMap<>();
+        /**
+         * {@return the subtypes for a type element, or an empty set if there are none}
+         *
+         * @param typeElement the type element
+         */
+        SortedSet<TypeElement> getSubtypes(TypeElement typeElement) {
+            return computeIfAbsent(typeElement, te -> new TreeSet<>(comparator));
+        }
 
-    private final SortedSet<TypeElement> baseEnums;
-    private final Map<TypeElement, SortedSet<TypeElement>> subEnums = new HashMap<>();
+        /**
+         * Adds a subtype into the set of subtypes for a type element
+         *
+         * @param typeElement the type element
+         * @param subtype the subtype
+         * @return {@code true} if this set did not already contain the specified element
+         */
+        boolean addSubtype(TypeElement typeElement, TypeElement subtype) {
+            return getSubtypes(typeElement).add(subtype);
+        }
+    }
 
-    private final SortedSet<TypeElement> baseAnnotationTypes;
-    private final Map<TypeElement, SortedSet<TypeElement>> subAnnotationTypes = new HashMap<>();
+    /**
+     * The collection of hierarchies, indexed by kind.
+     */
+    private final Map<HierarchyKind, Hierarchy> hierarchies;
 
    /**
-    * Mapping for each Interface with classes who implement it.
+    * Mapping for each interface with classes that implement it.
     */
-    private final Map<TypeElement, SortedSet<TypeElement>> implementingClasses = new HashMap<>();
+    private final SubtypeMap implementingClasses;
 
     private final BaseConfiguration configuration;
     private final Utils utils;
-    private final Comparator<Element> comparator;
 
     /**
-     * Constructor. Build the Tree using the Root of this Javadoc run.
+     * Constructor. Build the tree for all the included type elements.
      *
-     * @param configuration the configuration of the doclet.
-     * @param noDeprecated Don't add deprecated classes in the class tree, if
-     * true.
+     * @param configuration the configuration of the doclet
      */
-    public ClassTree(BaseConfiguration configuration, boolean noDeprecated) {
+    public ClassTree(BaseConfiguration configuration) {
         this.configuration = configuration;
         this.utils = configuration.utils;
 
         Messages messages = configuration.getMessages();
         messages.notice("doclet.Building_Tree");
 
-        comparator = utils.comparators.makeClassUseComparator();
-        baseAnnotationTypes = new TreeSet<>(comparator);
-        baseEnums = new TreeSet<>(comparator);
-        baseClasses = new TreeSet<>(comparator);
-        baseInterfaces = new TreeSet<>(comparator);
-        buildTree(configuration.getIncludedTypeElements());
-    }
+        Comparator<Element> comparator = utils.comparators.makeClassUseComparator();
+
+        hierarchies = new EnumMap<>(HierarchyKind.class);
+        for (var hk : HierarchyKind.values()) {
+            hierarchies.put(hk, new Hierarchy(comparator));
+        }
+        implementingClasses = new SubtypeMap(comparator);
 
-    /**
-     * Constructor. Build the Tree using the Root of this Javadoc run.
-     *
-     * @param docEnv the DocletEnvironment.
-     * @param configuration The current configuration of the doclet.
-     */
-    public ClassTree(DocletEnvironment docEnv, BaseConfiguration configuration) {
-        this.configuration = configuration;
-        this.utils = configuration.utils;
-        comparator = utils.comparators.makeClassUseComparator();
-        baseAnnotationTypes = new TreeSet<>(comparator);
-        baseEnums = new TreeSet<>(comparator);
-        baseClasses = new TreeSet<>(comparator);
-        baseInterfaces = new TreeSet<>(comparator);
         buildTree(configuration.getIncludedTypeElements());
     }
 
     /**
-     * Constructor. Build the tree for the given array of classes.
+     * Constructor. Build the tree for the given collection of classes.
      *
      * @param classesSet a set of classes
      * @param configuration The current configuration of the doclet.
      */
-    public ClassTree(SortedSet<TypeElement>classesSet, BaseConfiguration configuration) {
+    public ClassTree(SortedSet<TypeElement> classesSet, BaseConfiguration configuration) {
         this.configuration = configuration;
         this.utils = configuration.utils;
-        comparator = utils.comparators.makeClassUseComparator();
-        baseAnnotationTypes = new TreeSet<>(comparator);
-        baseEnums = new TreeSet<>(comparator);
-        baseClasses = new TreeSet<>(comparator);
-        baseInterfaces = new TreeSet<>(comparator);
+
+        Comparator<Element> comparator = utils.comparators.makeClassUseComparator();
+
+        hierarchies = new EnumMap<>(HierarchyKind.class);
+        for (var hk : HierarchyKind.values()) {
+            hierarchies.put(hk, new Hierarchy(comparator));
+        }
+        implementingClasses = new SubtypeMap(comparator);
+
         buildTree(classesSet);
     }
 
     /**
-     * Generate mapping for the sub-classes for every class in this run.
-     * Return the sub-class set for java.lang.Object which will be having
-     * sub-class listing for itself and also for each sub-class itself will
-     * have their own sub-class lists.
+     * Generate the hierarchies for the given type elements.
      *
-     * @param classes all the classes in this run.
+     * @param typeElements the type elements
      */
-    private void buildTree(Iterable<TypeElement> classes) {
-        for (TypeElement aClass : classes) {
+    private void buildTree(Iterable<TypeElement> typeElements) {
+        for (TypeElement te : typeElements) {
             // In the tree page (e.g overview-tree.html) do not include
             // information of classes which are deprecated or are a part of a
             // deprecated package.
             if (configuration.getOptions().noDeprecated() &&
-                    (utils.isDeprecated(aClass) ||
-                    utils.isDeprecated(utils.containingPackage(aClass)))) {
+                    (utils.isDeprecated(te) ||
+                    utils.isDeprecated(utils.containingPackage(te)))) {
                 continue;
             }
 
-            if (utils.hasHiddenTag(aClass)) {
+            if (utils.hasHiddenTag(te)) {
                 continue;
             }
 
-            if (utils.isEnum(aClass)) {
-                processType(aClass, configuration, baseEnums, subEnums);
-            } else if (utils.isClass(aClass)) {
-                processType(aClass, configuration, baseClasses, subClasses);
-            } else if (utils.isPlainInterface(aClass)) {
-                processInterface(aClass);
-            } else if (utils.isAnnotationInterface(aClass)) {
-                processType(aClass, configuration, baseAnnotationTypes,
-                    subAnnotationTypes);
+            if (utils.isEnum(te)) {
+                processType(te, hierarchies.get(HierarchyKind.ENUM_CLASSES));
+            } else if (utils.isRecord(te)) {
+                processType(te, hierarchies.get(HierarchyKind.RECORD_CLASSES));
+            } else if (utils.isClass(te)) {
+                processType(te, hierarchies.get(HierarchyKind.CLASSES));
+            } else if (utils.isPlainInterface(te)) {
+                processInterface(te);
+            } else if (utils.isAnnotationInterface(te)) {
+                processType(te, hierarchies.get(HierarchyKind.ANNOTATION_INTERFACES));
             }
         }
     }
 
     /**
-     * For the class passed map it to its own sub-class listing.
-     * For the Class passed, get the super class,
-     * if superclass is non null, (it is not "java.lang.Object")
-     * get the "value" from the hashmap for this key Class
-     * if entry not found create one and get that.
-     * add this Class as a sub class in the set
-     * Recurse till hits java.lang.Object Null SuperClass.
+     * Adds details for a type element into a given hierarchy.
      *
-     * @param typeElement for which sub class mapping is to be generated.
-     * @param configuration the current configuration of the doclet.
+     * The subtypes are updated for the transitive closure of all supertypes of this type element.
+     * If this type element has no superclass or superinterfaces, it is marked as a root.
+     *
+     * @param typeElement for which the hierarchy is to be generated
+     * @param hierarchy the hierarchy
      */
-    private void processType(TypeElement typeElement, BaseConfiguration configuration,
-            Collection<TypeElement> bases, Map<TypeElement, SortedSet<TypeElement>> subs) {
+    private void processType(TypeElement typeElement, Hierarchy hierarchy) {
         TypeElement superclass = utils.getFirstVisibleSuperClassAsTypeElement(typeElement);
         if (superclass != null) {
-            if (!add(subs, superclass, typeElement)) {
+            if (!hierarchy.subtypes.addSubtype(superclass, typeElement)) {
                 return;
             } else {
-                processType(superclass, configuration, bases, subs);
+                processType(superclass, hierarchy);
             }
         } else {     // typeElement is java.lang.Object, add it once to the set
-            if (!bases.contains(typeElement)) {
-                bases.add(typeElement);
-            }
+            hierarchy.roots.add(typeElement);
         }
-        Set<TypeMirror> intfacs = utils.getAllInterfaces(typeElement);
-        for (TypeMirror intfac : intfacs) {
-            add(implementingClasses, utils.asTypeElement(intfac), typeElement);
+
+        Set<TypeMirror> interfaces = utils.getAllInterfaces(typeElement);
+        for (TypeMirror t : interfaces) {
+            implementingClasses.addSubtype(utils.asTypeElement(t), typeElement);
         }
     }
 
     /**
      * For the interface passed get the interfaces which it extends, and then
      * put this interface in the sub-interface set of those interfaces. Do it
-     * recursively. If a interface doesn't have super-interface just attach
+     * recursively. If an interface doesn't have super-interface just attach
      * that interface in the set of all the baseInterfaces.
      *
      * @param typeElement Interface under consideration.
      */
     private void processInterface(TypeElement typeElement) {
-        List<? extends TypeMirror> intfacs = typeElement.getInterfaces();
-        if (!intfacs.isEmpty()) {
-            for (TypeMirror intfac : intfacs) {
-                if (!add(subInterfaces, utils.asTypeElement(intfac), typeElement)) {
+        Hierarchy interfacesHierarchy = hierarchies.get(HierarchyKind.INTERFACES);
+        List<? extends TypeMirror> interfaces = typeElement.getInterfaces();
+        if (!interfaces.isEmpty()) {
+            for (TypeMirror t : interfaces) {
+                if (!interfacesHierarchy.subtypes.addSubtype(utils.asTypeElement(t), typeElement)) {
                     return;
                 } else {
-                    processInterface(utils.asTypeElement(intfac));   // Recurse
+                    processInterface(utils.asTypeElement(t));   // Recurse
                 }
             }
         } else {
             // we need to add all the interfaces who do not have
-            // super-interfaces to baseInterfaces set to traverse them
-            if (!baseInterfaces.contains(typeElement)) {
-                baseInterfaces.add(typeElement);
-            }
-        }
-    }
-
-    /**
-     * Adjust the Class Tree. Add the class interface  in to it's super classes
-     * or super interface's sub-interface set.
-     *
-     * @param map the entire map.
-     * @param superclass java.lang.Object or the super-interface.
-     * @param typeElement sub-interface to be mapped.
-     * @return true if class added, false if class already processed.
-     */
-    private boolean add(Map<TypeElement, SortedSet<TypeElement>> map, TypeElement superclass, TypeElement typeElement) {
-        SortedSet<TypeElement> sset = map.computeIfAbsent(superclass, s ->  new TreeSet<>(comparator));
-        if (sset.contains(typeElement)) {
-            return false;
-        } else {
-            sset.add(typeElement);
+            // super-interfaces to the root set to traverse them
+            interfacesHierarchy.roots.add(typeElement);
         }
-        return true;
-    }
-
-    /**
-     * From the map return the set of sub-classes or sub-interfaces. If set
-     * is null create a new one and return it.
-     *
-     * @param map The entire map.
-     * @param typeElement class for which the sub-class set is requested.
-     * @return a set of sub classes.
-     */
-    private SortedSet<TypeElement> get(Map<TypeElement, SortedSet<TypeElement>> map, TypeElement typeElement) {
-        return map.computeIfAbsent(typeElement, t ->  new TreeSet<>(comparator));
     }
 
     /**
@@ -277,7 +310,7 @@ private SortedSet<TypeElement> get(Map<TypeElement, SortedSet<TypeElement>> map,
      * @param typeElement class whose sub-class set is required.
      */
     public SortedSet<TypeElement> subClasses(TypeElement typeElement) {
-        return get(subClasses, typeElement);
+        return hierarchies.get(HierarchyKind.CLASSES).subtypes(typeElement);
     }
 
     /**
@@ -286,7 +319,7 @@ public SortedSet<TypeElement> subClasses(TypeElement typeElement) {
      * @param typeElement interface whose sub-interface set is required.
      */
     public SortedSet<TypeElement> subInterfaces(TypeElement typeElement) {
-        return get(subInterfaces, typeElement);
+        return hierarchies.get(HierarchyKind.INTERFACES).subtypes(typeElement);
     }
 
     /**
@@ -295,106 +328,61 @@ public SortedSet<TypeElement> subInterfaces(TypeElement typeElement) {
      * @param typeElement interface whose implementing-classes set is required.
      */
     public SortedSet<TypeElement> implementingClasses(TypeElement typeElement) {
-        SortedSet<TypeElement> result = get(implementingClasses, typeElement);
-        SortedSet<TypeElement> intfcs = allSubClasses(typeElement, false);
+        SortedSet<TypeElement> result = implementingClasses.getSubtypes(typeElement);
+        SortedSet<TypeElement> interfaces = hierarchy(typeElement).allSubtypes(typeElement);
 
         // If class x implements a subinterface of typeElement, then it follows
         // that class x implements typeElement.
-        Iterator<TypeElement> subInterfacesIter = intfcs.iterator();
-        while (subInterfacesIter.hasNext()) {
-            Iterator<TypeElement> implementingClassesIter
-                    = implementingClasses(subInterfacesIter.next()).iterator();
-            while (implementingClassesIter.hasNext()) {
-                TypeElement c = implementingClassesIter.next();
-                if (!result.contains(c)) {
-                    result.add(c);
-                }
-            }
+        for (TypeElement te : interfaces) {
+            result.addAll(implementingClasses(te));
         }
         return result;
     }
 
-    /**
-     * Return the sub-class/interface set for the class/interface passed.
-     *
-     * @param typeElement class/interface whose sub-class/interface set is required.
-     * @param isEnum true if the subClasses should be forced to come from the
-     * enum tree.
-     */
-    public SortedSet<TypeElement> directSubClasses(TypeElement typeElement, boolean isEnum) {
-        return directSubClasses0(typeElement, isEnum);
-    }
-
-    private SortedSet<TypeElement> directSubClasses0(TypeElement typeElement, boolean isEnum) {
-        if (isEnum) {
-            return get(subEnums, typeElement);
-        } else if (utils.isAnnotationInterface(typeElement)) {
-            return get(subAnnotationTypes, typeElement);
-        } else if (utils.isPlainInterface(typeElement)) {
-            return get(subInterfaces, typeElement);
-        } else if (utils.isClass(typeElement)) {
-            return get(subClasses, typeElement);
-        } else {
-            return Collections.emptySortedSet();
-        }
+    public Hierarchy hierarchy(TypeElement typeElement) {
+        HierarchyKind hk = switch (typeElement.getKind()) {
+            case CLASS -> HierarchyKind.CLASSES;
+            case ENUM -> HierarchyKind.ENUM_CLASSES;
+            case RECORD -> HierarchyKind.RECORD_CLASSES;
+            case INTERFACE -> HierarchyKind.INTERFACES;
+            case ANNOTATION_TYPE -> HierarchyKind.ANNOTATION_INTERFACES;
+            default -> throw new IllegalArgumentException(typeElement.getKind().name() + " " + typeElement.getQualifiedName());
+        };
+        return hierarchies.get(hk);
     }
 
     /**
-     * Return a set of all direct or indirect, sub-classes and subInterfaces
-     * of the TypeElement argument.
-     *
-     * @param typeElement TypeElement whose sub-classes or sub-interfaces are requested.
-     * @param isEnum true if the subClasses should be forced to come from the
-     * enum tree.
+     * {@return the hierarchy for which the leaf nodes are plain classes}
      */
-    public SortedSet<TypeElement> allSubClasses(TypeElement typeElement, boolean isEnum) {
-        // new entries added to the set are searched as well, this is
-        // really a work queue.
-        List<TypeElement> list = new ArrayList<>(directSubClasses(typeElement, isEnum));
-        for (int i = 0; i < list.size(); i++) {
-            TypeElement te = list.get(i);
-            SortedSet<TypeElement> tset = directSubClasses0(te, isEnum);
-            for (TypeElement tte : tset) {
-                if (!list.contains(tte)) {
-                    list.add(tte);
-                }
-            }
-        }
-        SortedSet<TypeElement> out = new TreeSet<>(comparator);
-        out.addAll(list);
-        return out;
+    public Hierarchy classes() {
+        return hierarchies.get(HierarchyKind.CLASSES);
     }
 
     /**
-     * Return a set of base classes. This will have only one element namely
-     * the TypeElement for java.lang.Object, since this is the base class for all
-     * classes.
+     * {@return the hierarchy for which the leaf nodes are enum classes}
      */
-    public SortedSet<TypeElement> baseClasses() {
-        return baseClasses;
+    public Hierarchy enumClasses() {
+        return hierarchies.get(HierarchyKind.ENUM_CLASSES);
     }
 
     /**
-     * Return the set of base interfaces. This is the set of interfaces
-     * which do not have super-interface.
+     * {@return the hierarchy for which the leaf nodes are record classes}
      */
-    public SortedSet<TypeElement> baseInterfaces() {
-        return baseInterfaces;
+    public Hierarchy recordClasses() {
+        return hierarchies.get(HierarchyKind.RECORD_CLASSES);
     }
 
     /**
-     * Return the set of base enums. This is the set of enums
-     * which do not have super-enums.
+     * {@return the hierarchy for which the leaf nodes are plain interfaces}
      */
-    public SortedSet<TypeElement> baseEnums() {
-        return baseEnums;
+    public Hierarchy interfaces() {
+        return hierarchies.get(HierarchyKind.INTERFACES);
     }
 
     /**
-     * Return the set of base annotation types. This is the set
-     * of annotation types which do not have super-annotation types.
+     * {@return the hierarchy for which the leaf nodes are annotation interfaces}
      */
-    public SortedSet<TypeElement> baseAnnotationTypes() {
-        return baseAnnotationTypes;
+    public Hierarchy annotationInterfaces() {
+        return hierarchies.get(HierarchyKind.ANNOTATION_INTERFACES);
     }
 }