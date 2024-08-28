@@ -79,8 +79,6 @@ public final class Utils {
     public static final String ACCESS_FLIGHT_RECORDER = "accessFlightRecorder";
     private static final String LEGACY_EVENT_NAME_PREFIX = "com.oracle.jdk.";
 
-    private static Boolean SAVE_GENERATED;
-
     private static final Duration MICRO_SECOND = Duration.ofNanos(1_000);
     private static final Duration SECOND = Duration.ofSeconds(1);
     private static final Duration MINUTE = Duration.ofMinutes(1);
@@ -514,31 +512,6 @@ public static void ensureValidEventSubclass(Class<?> eventClass) {
         }
     }
 
-    public static void writeGeneratedASM(String className, byte[] bytes) {
-        if (SAVE_GENERATED == null) {
-            // We can't calculate value statically because it will force
-            // initialization of SecuritySupport, which cause
-            // UnsatisfiedLinkedError on JDK 8 or non-Oracle JDKs
-            SAVE_GENERATED = SecuritySupport.getBooleanProperty("jfr.save.generated.asm");
-        }
-        if (SAVE_GENERATED) {
-            className = className.substring(className.lastIndexOf("/") + 1, className.length());
-            try {
-                try (FileOutputStream fos = new FileOutputStream(className + ".class")) {
-                    fos.write(bytes);
-                }
-
-                try (FileWriter fw = new FileWriter(className + ".asm"); PrintWriter pw = new PrintWriter(fw)) {
-                    ClassReader cr = new ClassReader(bytes);
-                    CheckClassAdapter.verify(cr, true, pw);
-                }
-                Logger.log(LogTag.JFR_SYSTEM_BYTECODE, LogLevel.INFO, "Instrumented code saved to " + className + ".class and .asm");
-            } catch (IOException e) {
-                Logger.log(LogTag.JFR_SYSTEM_BYTECODE, LogLevel.INFO, "Could not save instrumented code, for " + className + ".class and .asm");
-            }
-        }
-    }
-
     public static void ensureInitialized(Class<? extends jdk.internal.event.Event> eventClass) {
         SecuritySupport.ensureClassIsInitialized(eventClass);
     }