@@ -181,7 +181,7 @@ static EnumSet<DependenciesMode> getDependenciesModes(String[] modes) {
         public abstract static class Node extends GraphUtils.AbstractNode<ClassSymbol, Node>
                 implements GraphUtils.DottableNode<ClassSymbol, Node> {
             /**
-             * dependant nodes grouped by kind
+             * dependent nodes grouped by kind
              */
             EnumMap<CompletionCause, List<Node>> depsByKind;
 