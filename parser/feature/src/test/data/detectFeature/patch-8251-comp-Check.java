@@ -3337,7 +3337,7 @@ public Name[] getTargetNames(TypeSymbol annoSym) {
 
     boolean annotationApplicable(JCAnnotation a, Symbol s) {
         Optional<Set<Name>> targets = getApplicableTargets(a, s);
-        /* the optional could be emtpy if the annotation is unknown in that case
+        /* the optional could be empty if the annotation is unknown in that case
          * we return that it is applicable and if it is erroneous that should imply
          * an error at the declaration site
          */