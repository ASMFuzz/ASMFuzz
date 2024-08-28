@@ -125,7 +125,7 @@ public synchronized void deactivate(boolean isTemporary) {
         /* Usually as the client component, let's call it component A,
            loses the focus, this method is called. Then when another client
            component, let's call it component B,  gets the focus, activate is first called on
-           the previous focused compoent which is A, then endComposition is called on A,
+           the previous focused component which is A, then endComposition is called on A,
            deactivate is called on A again. And finally activate is called on the newly
            focused component B. Here is the call sequence.
 
@@ -466,7 +466,7 @@ public void setCompositionEnabled(boolean enable) {
            return.
            setCompositionEnabledNative may throw UnsupportedOperationException.
            Don't try to catch it since the method may be called by clients.
-           Use package private mthod 'resetCompositionState' if you want the
+           Use package private method 'resetCompositionState' if you want the
            exception to be caught.
         */
         boolean pre, post;