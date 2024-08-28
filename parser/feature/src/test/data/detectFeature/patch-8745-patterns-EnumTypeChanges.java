@@ -64,7 +64,7 @@ String statementEnum(EnumTypeChangesEnum e) {
         switch (e) {
             case A -> { return "A"; }
             case B -> { return "B"; }
-            case EnumTypeChangesEnum e1 when false -> throw new AssertionError();
+            case EnumTypeChangesEnum e1 when e1 == null -> throw new AssertionError();
             default -> { return "D"; }
         }
     }
@@ -73,7 +73,7 @@ String expressionEnum(EnumTypeChangesEnum e) {
         return switch (e) {
             case A -> "A";
             case B -> "B";
-            case EnumTypeChangesEnum e1 when false -> throw new AssertionError();
+            case EnumTypeChangesEnum e1 when e1 == null -> throw new AssertionError();
             default -> "D";
         };
     }