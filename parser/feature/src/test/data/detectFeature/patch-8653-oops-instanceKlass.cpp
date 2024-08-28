@@ -711,25 +711,6 @@ klassItable InstanceKlass::itable() const {
   return klassItable(const_cast<InstanceKlass*>(this));
 }
 
-void InstanceKlass::eager_initialize(Thread *thread) {
-  if (!EagerInitialization) return;
-
-  if (this->is_not_initialized()) {
-    // abort if the the class has a class initializer
-    if (this->class_initializer() != NULL) return;
-
-    // abort if it is java.lang.Object (initialization is handled in genesis)
-    Klass* super_klass = super();
-    if (super_klass == NULL) return;
-
-    // abort if the super class should be initialized
-    if (!InstanceKlass::cast(super_klass)->is_initialized()) return;
-
-    // call body to expose the this pointer
-    eager_initialize_impl();
-  }
-}
-
 // JVMTI spec thinks there are signers and protection domain in the
 // instanceKlass.  These accessors pretend these fields are there.
 // The hprof specification also thinks these fields are in InstanceKlass.
@@ -764,38 +745,6 @@ void InstanceKlass::fence_and_clear_init_lock() {
   assert(!is_not_initialized(), "class must be initialized now");
 }
 
-void InstanceKlass::eager_initialize_impl() {
-  EXCEPTION_MARK;
-  HandleMark hm(THREAD);
-  Handle h_init_lock(THREAD, init_lock());
-  ObjectLocker ol(h_init_lock, THREAD);
-
-  // abort if someone beat us to the initialization
-  if (!is_not_initialized()) return;  // note: not equivalent to is_initialized()
-
-  ClassState old_state = init_state();
-  link_class_impl(THREAD);
-  if (HAS_PENDING_EXCEPTION) {
-    CLEAR_PENDING_EXCEPTION;
-    // Abort if linking the class throws an exception.
-
-    // Use a test to avoid redundantly resetting the state if there's
-    // no change.  Set_init_state() asserts that state changes make
-    // progress, whereas here we might just be spinning in place.
-    if (old_state != _init_state)
-      set_init_state(old_state);
-  } else {
-    // linking successful, mark class as initialized
-    set_init_state(fully_initialized);
-    fence_and_clear_init_lock();
-    // trace
-    if (log_is_enabled(Info, class, init)) {
-      ResourceMark rm(THREAD);
-      log_info(class, init)("[Initialized %s without side effects]", external_name());
-    }
-  }
-}
-
 
 // See "The Virtual Machine Specification" section 2.16.5 for a detailed explanation of the class initialization
 // process. The step comments refers to the procedure described in that section.