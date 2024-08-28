@@ -338,6 +338,7 @@ public void onSubscribe(Flow.Subscription subscription) {
             if (isSubscribed()) {
                 Throwable t = new IllegalStateException("already subscribed");
                 http1Exchange.appendToOutgoing(t);
+                subscription.cancel();
             } else {
                 setSubscription(subscription);
             }
@@ -402,6 +403,7 @@ public void onSubscribe(Flow.Subscription subscription) {
             if (isSubscribed()) {
                 Throwable t = new IllegalStateException("already subscribed");
                 http1Exchange.appendToOutgoing(t);
+                subscription.cancel();
             } else {
                 setSubscription(subscription);
             }