@@ -136,7 +136,7 @@ public void testOutsideConfinementThread() throws Throwable {
 
                     setInt(s2.asSlice(4), -42);
                     fail();
-                } catch (IllegalStateException ex) {
+                } catch (WrongThreadException ex) {
                     assertTrue(ex.getMessage().contains("owning thread"));
                 }
             });