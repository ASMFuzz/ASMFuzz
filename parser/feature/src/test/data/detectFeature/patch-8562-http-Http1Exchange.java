@@ -148,13 +148,26 @@ final boolean isSubscribed() {
         }
 
         final void setSubscription(Flow.Subscription subscription) {
-            this.subscription = subscription;
-            whenSubscribed.complete(subscription);
+            Flow.Subscription sub;
+            synchronized (this) {
+                if ((sub = this.subscription) == null) {
+                    this.subscription = sub = subscription;
+                }
+            }
+            if (sub == subscription) {
+                whenSubscribed.complete(subscription);
+            } else subscription.cancel();
         }
 
         final void cancelSubscription() {
             try {
-                subscription.cancel();
+                Flow.Subscription sub;
+                synchronized (this) {
+                    if ((sub = this.subscription) == null) {
+                        this.subscription = sub = HttpBodySubscriberWrapper.NOP;
+                    }
+                }
+                sub.cancel();
             } catch(Throwable t) {
                 String msg = "Ignoring exception raised when canceling BodyPublisher subscription";
                 if (debug.on()) debug.log("%s: %s", msg, t);
@@ -770,9 +783,10 @@ public void run() {
                     return;
                 }
 
-                if (debug.on()) debug.log(() -> "hasOutgoing = " + hasOutgoing());
+                if (debug.on()) debug.log(() -> "hasOutgoing = " + hasOutgoing() + ", demand = " + demand.get());
                 while (hasOutgoing() && demand.tryDecrement()) {
                     DataPair dp = getOutgoing();
+                    if (debug.on()) debug.log("outgoing: " + dp);
                     if (dp == null)
                         break;
 
@@ -794,7 +808,10 @@ public void run() {
                             // The next Subscriber will eventually take over.
 
                         } else {
-                            if (checkRequestCancelled()) return;
+                            if (checkRequestCancelled()) {
+                                if (debug.on()) debug.log("Request cancelled!");
+                                return;
+                            }
                             if (debug.on())
                                 debug.log("onNext with " + Utils.remaining(data) + " bytes");
                             subscriber.onNext(data);