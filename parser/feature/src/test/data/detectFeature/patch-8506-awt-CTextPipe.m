@@ -354,14 +354,21 @@ render using the right font (see bug 7183516) when attribString is not
     if (g_gtiTransformsArray == NULL) {
         return;
     }
+
+    DECLARE_FIELD(jm_StandardGlyphVector_GlyphTransformInfo_indices, jc_StandardGlyphVector_GlyphTransformInfo, "indices", "[I");
+    jintArray g_gtiTXIndicesArray = (*env)->GetObjectField(env, gti, jm_StandardGlyphVector_GlyphTransformInfo_indices);
+    if (g_gtiTXIndicesArray == NULL) {
+        (*env)->DeleteLocalRef(env, g_gtiTransformsArray);
+        return;
+    }
+
     jdouble *g_gvTransformsAsDoubles = (*env)->GetPrimitiveArrayCritical(env, g_gtiTransformsArray, NULL);
     if (g_gvTransformsAsDoubles == NULL) {
         (*env)->DeleteLocalRef(env, g_gtiTransformsArray);
+        (*env)->DeleteLocalRef(env, g_gtiTXIndicesArray);
         return;
     }
 
-    DECLARE_FIELD(jm_StandardGlyphVector_GlyphTransformInfo_indices, jc_StandardGlyphVector_GlyphTransformInfo, "indices", "[I");
-    jintArray g_gtiTXIndicesArray = (*env)->GetObjectField(env, gti, jm_StandardGlyphVector_GlyphTransformInfo_indices);
     jint *g_gvTXIndicesAsInts = (*env)->GetPrimitiveArrayCritical(env, g_gtiTXIndicesArray, NULL);
     if (g_gvTXIndicesAsInts == NULL) {
         (*env)->ReleasePrimitiveArrayCritical(env, g_gtiTransformsArray, g_gvTransformsAsDoubles, JNI_ABORT);