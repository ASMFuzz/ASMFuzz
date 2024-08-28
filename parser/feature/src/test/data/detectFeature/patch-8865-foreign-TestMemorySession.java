@@ -243,7 +243,7 @@ public void testCloseConfinedLock() {
         try {
             t.join();
             assertNotNull(failure.get());
-            assertEquals(failure.get().getClass(), IllegalStateException.class);
+            assertEquals(failure.get().getClass(), WrongThreadException.class);
         } catch (Throwable ex) {
             throw new AssertionError(ex);
         }