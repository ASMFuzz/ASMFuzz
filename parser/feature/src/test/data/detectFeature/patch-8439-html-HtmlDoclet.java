@@ -30,7 +30,14 @@
 import java.nio.file.Files;
 import java.nio.file.InvalidPathException;
 import java.nio.file.Path;
-import java.util.*;
+import java.util.ArrayList;
+import java.util.Arrays;
+import java.util.HashMap;
+import java.util.List;
+import java.util.Locale;
+import java.util.Map;
+import java.util.Set;
+import java.util.SortedSet;
 import java.util.function.Function;
 
 import javax.lang.model.SourceVersion;
@@ -256,6 +263,7 @@ protected void generateOtherFiles(ClassTree classTree)
         }
 
         if (options.createIndex()) {
+            ExternalSpecsWriter.generate(configuration);
             SystemPropertiesWriter.generate(configuration);
             configuration.mainIndex.addElements();
             IndexBuilder allClassesIndex = new IndexBuilder(configuration, nodeprecated, true);