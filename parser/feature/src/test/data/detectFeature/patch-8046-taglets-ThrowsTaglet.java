@@ -25,7 +25,6 @@
 
 package jdk.javadoc.internal.doclets.toolkit.taglets;
 
-import java.util.Collections;
 import java.util.EnumSet;
 import java.util.HashMap;
 import java.util.HashSet;
@@ -35,7 +34,6 @@
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Set;
-import java.util.stream.Collectors;
 
 import javax.lang.model.element.Element;
 import javax.lang.model.element.ExecutableElement;
@@ -251,6 +249,6 @@ private Map<String, TypeMirror> getSubstitutedThrownTypes(Types types,
             }
             return map;
         }
-        return Collections.emptyMap();
+        return Map.of();
     }
 }