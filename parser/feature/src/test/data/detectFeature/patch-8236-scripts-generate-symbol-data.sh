@@ -38,7 +38,7 @@
 #   directory.
 # - open a terminal program and run these commands:
 #     cd "${JDK_CHECKOUT}"/src/jdk.compiler/share/data/symbols
-#     bash ../../scripts/generate-symbol-data.sh "${JDK_N_INSTALL}"
+#     bash ../../../../../make/scripts/generate-symbol-data.sh "${JDK_N_INSTALL}"
 # - this command will generate or update data for "--release N" into the ${JDK_CHECKOUT}/src/jdk.compiler/share/data/symbols
 #   directory, updating all registration necessary. If the goal was to update the data, and there are no
 #   new or changed files in the ${JDK_CHECKOUT}/src/jdk.compiler/share/data/symbols directory after running this script,
@@ -73,5 +73,5 @@ $1/bin/java --add-exports jdk.jdeps/com.sun.tools.classfile=ALL-UNNAMED \
             --add-exports jdk.compiler/com.sun.tools.javac.jvm=ALL-UNNAMED \
             --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED \
             --add-modules jdk.jdeps \
-            ../../../make/langtools/src/classes/build/tools/symbolgenerator/CreateSymbols.java \
+            ../../../../../make/langtools/src/classes/build/tools/symbolgenerator/CreateSymbols.java \
             build-description-incremental symbols include.list