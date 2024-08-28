@@ -739,7 +739,6 @@ private static void printJfrEventClassesHpp(Metadata metadata, File outputFile)
             out.write("#include \"utilities/ticks.hpp\"");
             out.write("#if INCLUDE_JFR");
             out.write("#include \"jfr/recorder/service/jfrEvent.hpp\"");
-            out.write("#include \"jfr/support/jfrEpochSynchronization.hpp\"");
             out.write("/*");
             out.write(" * Each event class has an assert member function verify() which is invoked");
             out.write(" * just before the engine writes the event and its fields to the data stream.");
@@ -869,10 +868,6 @@ private static void printWriteData(Printer out, TypeElement type) {
         if (type.isEvent && type.internal) {
             out.write("    JfrEventSetting::unhide_internal_types();");
         }
-        if (("_thread_in_native").equals(type.commitState)) {
-            out.write("    // explicit epoch synchronization check");
-            out.write("    JfrEpochSynchronization sync;");
-        }
         for (FieldElement field : type.fields) {
             if (field.struct) {
                 out.write("    _" + field.name + ".writeData(w);");