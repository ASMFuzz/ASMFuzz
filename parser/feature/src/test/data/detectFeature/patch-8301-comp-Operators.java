@@ -74,10 +74,10 @@ public class Operators {
     private final Types types;
 
     /** Unary operators map. */
-    private Map<Name, List<UnaryOperatorHelper>> unaryOperators = new HashMap<>(Tag.getNumberOfOperators());
+    private Map<Name, List<UnaryOperatorHelper>> unaryOperators = new HashMap<>((int) Math.ceil(Tag.getNumberOfOperators() / 0.75));
 
     /** Binary operators map. */
-    private Map<Name, List<BinaryOperatorHelper>> binaryOperators = new HashMap<>(Tag.getNumberOfOperators());
+    private Map<Name, List<BinaryOperatorHelper>> binaryOperators = new HashMap<>((int) Math.ceil(Tag.getNumberOfOperators() / 0.75));
 
     /** The names of all operators. */
     private Name[] opname = new Name[Tag.getNumberOfOperators()];