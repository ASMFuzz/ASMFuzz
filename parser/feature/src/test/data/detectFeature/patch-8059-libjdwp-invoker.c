@@ -810,6 +810,7 @@ invoker_completeInvokeRequest(jthread thread)
             tossGlobalRef(env, &exc);
         }
         outStream_sendReply(&out);
+        outStream_destroy(&out);
     }
 }
 