@@ -296,6 +296,11 @@ static inline void autoDelay(BOOL isMove) {
         CGKeyCode keyCode = GetCGKeyCode(javaKeyCode);
         CGEventRef event = CGEventCreateKeyboardEvent(source, keyCode, keyPressed);
         if (event != NULL) {
+            CGEventFlags flags = CGEventSourceFlagsState(kCGEventSourceStateHIDSystemState);
+            if ((flags & kCGEventFlagMaskSecondaryFn) != 0) {
+                flags ^= kCGEventFlagMaskSecondaryFn;
+                CGEventSetFlags(event, flags);
+            }
             CGEventPost(kCGHIDEventTap, event);
             CFRelease(event);
         }