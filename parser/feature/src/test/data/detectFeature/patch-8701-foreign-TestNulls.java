@@ -47,6 +47,7 @@
 import java.lang.reflect.InvocationTargetException;
 import java.lang.reflect.Method;
 import java.lang.reflect.Modifier;
+import java.nio.Buffer;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.nio.channels.FileChannel;
@@ -145,6 +146,7 @@ static <Z> void addDefaultMapping(Class<Z> carrier, Z value) {
         addDefaultMapping(ByteOrder.class, ByteOrder.nativeOrder());
         addDefaultMapping(Thread.class, Thread.currentThread());
         addDefaultMapping(Cleaner.class, CleanerFactory.cleaner());
+        addDefaultMapping(Buffer.class, ByteBuffer.wrap(new byte[10]));
         addDefaultMapping(ByteBuffer.class, ByteBuffer.wrap(new byte[10]));
         addDefaultMapping(Path.class, Path.of("nonExistent"));
         addDefaultMapping(FileChannel.MapMode.class, FileChannel.MapMode.PRIVATE);