@@ -99,7 +99,7 @@ public <Z> void testOpOutsideConfinement(String name, ScopedOperation<Z> scopedO
             t.start();
             t.join();
             assertNotNull(failed.get());
-            assertEquals(failed.get().getClass(), IllegalStateException.class);
+            assertEquals(failed.get().getClass(), WrongThreadException.class);
             assertTrue(failed.get().getMessage().contains("outside"));
         } catch (InterruptedException ex) {
             throw new AssertionError(ex);