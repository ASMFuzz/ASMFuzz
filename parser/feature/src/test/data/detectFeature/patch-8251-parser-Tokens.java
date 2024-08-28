@@ -319,14 +319,14 @@ enum Tag {
 
         Token[] split(Tokens tokens) {
             if (kind.name.length() < 2 || kind.tag != Tag.DEFAULT) {
-                throw new AssertionError("Cant split" + kind);
+                throw new AssertionError("Can't split" + kind);
             }
 
             TokenKind t1 = tokens.lookupKind(kind.name.substring(0, 1));
             TokenKind t2 = tokens.lookupKind(kind.name.substring(1));
 
             if (t1 == null || t2 == null) {
-                throw new AssertionError("Cant split - bad subtokens");
+                throw new AssertionError("Can't split - bad subtokens");
             }
             return new Token[] {
                 new Token(t1, pos, pos + t1.name.length(), comments),