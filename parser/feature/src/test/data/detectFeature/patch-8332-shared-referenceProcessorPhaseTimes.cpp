@@ -73,7 +73,7 @@ static const char* PhaseNames[ReferenceProcessor::RefPhaseMax] = {
        };
 
 static const char* ReferenceTypeNames[REF_PHANTOM + 1] = {
-       "None", "Other", "SoftReference", "WeakReference", "FinalReference", "PhantomReference"
+       "None", "SoftReference", "WeakReference", "FinalReference", "PhantomReference"
        };
 
 STATIC_ASSERT((REF_PHANTOM + 1) == ARRAY_SIZE(ReferenceTypeNames));