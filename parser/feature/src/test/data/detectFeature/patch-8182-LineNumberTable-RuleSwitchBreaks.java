@@ -69,7 +69,7 @@ private void test(int i) {                        // 2
                      public class TestGuards {                             // 1
                          private void test(Object o) {                     // 2
                              switch (o) {                                  // 3
-                                 case String s && s.isEmpty() ->           // 4
+                                 case String s when s.isEmpty() ->         // 4
                                      System.out.println("a");              // 5
                                  case String s ->                          // 6
                                      System.out.println("a");              // 7