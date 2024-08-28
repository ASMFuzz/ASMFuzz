@@ -31,7 +31,6 @@
 import java.text.BreakIterator;
 import java.text.Collator;
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.Comparator;
 import java.util.IllformedLocaleException;
 import java.util.List;
@@ -349,7 +348,7 @@ Result begin(String... argv) {
             error("main.cant.read", e.getMessage());
             return ERROR;
         }
-        return begin(allArgs, Collections.emptySet());
+        return begin(allArgs, Set.of());
     }
 
     // Called by the JSR 199 API
@@ -638,7 +637,7 @@ int consumeDocletOption(int idx, List<String> args, boolean isToolOption) throws
                             text = log.getText("main.unnecessary_arg_provided", argBase);
                             throw new OptionException(ERROR, this::showUsage, text);
                         case 1:
-                            if (!opt.process(arg, Collections.singletonList(argVal))) {
+                            if (!opt.process(arg, List.of(argVal))) {
                                 m = -1;
                             }
                             break;