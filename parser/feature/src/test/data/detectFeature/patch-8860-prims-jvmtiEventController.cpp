@@ -771,15 +771,15 @@ void JvmtiEventControllerPrivate::set_event_callbacks(JvmtiEnvBase *env,
   flush_object_free_events(env);
 
   env->set_event_callbacks(callbacks, size_of_callbacks);
-  // Mask to clear normal event bits.
-  const jlong CLEARING_MASK = (1L >> (TOTAL_MIN_EVENT_TYPE_VAL - TOTAL_MIN_EVENT_TYPE_VAL)) - 1L;
-  // Avoid cleaning extension event bits.
-  jlong enabled_bits = CLEARING_MASK & env->env_event_enable()->_event_callback_enabled.get_bits();
 
+  jlong enabled_bits = env->env_event_enable()->_event_callback_enabled.get_bits();
   for (int ei = JVMTI_MIN_EVENT_TYPE_VAL; ei <= JVMTI_MAX_EVENT_TYPE_VAL; ++ei) {
     jvmtiEvent evt_t = (jvmtiEvent)ei;
+    jlong bit_for = JvmtiEventEnabled::bit_for(evt_t);
     if (env->has_callback(evt_t)) {
-      enabled_bits |= JvmtiEventEnabled::bit_for(evt_t);
+      enabled_bits |= bit_for;
+    } else {
+      enabled_bits &= ~bit_for;
     }
   }
   env->env_event_enable()->_event_callback_enabled.set_bits(enabled_bits);