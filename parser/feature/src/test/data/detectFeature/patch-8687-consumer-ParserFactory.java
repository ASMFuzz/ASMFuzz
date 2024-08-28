@@ -122,31 +122,23 @@ private Parser createParser(ValueDescriptor v, boolean event) throws IOException
     }
 
     private Parser createPrimitiveParser(Type type, boolean event) throws IOException {
-        switch (type.getName()) {
-        case "int":
-            return new IntegerParser();
-        case "long":
-            return new LongParser();
-        case "float":
-            return new FloatParser();
-        case "double":
-            return new DoubleParser();
-        case "char":
-            return new CharacterParser();
-        case "boolean":
-            return new BooleanParser();
-        case "short":
-            return new ShortParser();
-        case "byte":
-            return new ByteParser();
-        case "java.lang.String":
-            ConstantMap pool = new ConstantMap(ObjectFactory.create(type, timeConverter), type);
-            ConstantLookup lookup = new ConstantLookup(pool, type);
-            constantLookups.put(type.getId(), lookup);
-            return new StringParser(lookup, event);
-        default:
-            throw new IOException("Unknown primitive type " + type.getName());
-        }
+        return switch (type.getName()) {
+            case "int" ->  new IntegerParser();
+            case "long" -> new LongParser();
+            case "float" ->  new FloatParser();
+            case "double" -> new DoubleParser();
+            case "char" ->  new CharacterParser();
+            case "boolean" -> new BooleanParser();
+            case "short" -> new ShortParser();
+            case "byte" ->  new ByteParser();
+            case "java.lang.String" -> {
+                ConstantMap pool = new ConstantMap(ObjectFactory.create(type, timeConverter), type);
+                ConstantLookup lookup = new ConstantLookup(pool, type);
+                constantLookups.put(type.getId(), lookup);
+                yield new StringParser(lookup, event);
+            }
+            default ->  throw new IOException("Unknown primitive type " + type.getName());
+        };
     }
 
     private Parser registerParserType(Type t, Parser parser) {