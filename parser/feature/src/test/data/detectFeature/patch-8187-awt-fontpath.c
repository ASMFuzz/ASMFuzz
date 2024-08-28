@@ -523,6 +523,7 @@ typedef FcFontSet* (*FcFontSortFuncType)(FcConfig *config,
                                          FcResult *result);
 typedef FcCharSet* (*FcCharSetUnionFuncType)(const FcCharSet *a,
                                              const FcCharSet *b);
+typedef FcCharSet* (*FcCharSetDestroyFuncType)(FcCharSet *fcs);
 typedef FcChar32 (*FcCharSetSubtractCountFuncType)(const FcCharSet *a,
                                                    const FcCharSet *b);
 
@@ -808,6 +809,7 @@ Java_sun_font_FontConfigManager_getFontConfig
     FcFontSortFuncType FcFontSort;
     FcFontSetDestroyFuncType FcFontSetDestroy;
     FcCharSetUnionFuncType FcCharSetUnion;
+    FcCharSetDestroyFuncType FcCharSetDestroy;
     FcCharSetSubtractCountFuncType FcCharSetSubtractCount;
     FcGetVersionFuncType FcGetVersion;
     FcConfigGetCacheDirsFuncType FcConfigGetCacheDirs;
@@ -887,6 +889,8 @@ Java_sun_font_FontConfigManager_getFontConfig
         (FcFontSetDestroyFuncType)dlsym(libfontconfig, "FcFontSetDestroy");
     FcCharSetUnion =
         (FcCharSetUnionFuncType)dlsym(libfontconfig, "FcCharSetUnion");
+    FcCharSetDestroy =
+        (FcCharSetDestroyFuncType)dlsym(libfontconfig, "FcCharSetDestroy");
     FcCharSetSubtractCount =
         (FcCharSetSubtractCountFuncType)dlsym(libfontconfig,
                                               "FcCharSetSubtractCount");
@@ -902,6 +906,7 @@ Java_sun_font_FontConfigManager_getFontConfig
         FcPatternGetCharSet  == NULL ||
         FcFontSetDestroy     == NULL ||
         FcCharSetUnion       == NULL ||
+        FcCharSetDestroy     == NULL ||
         FcGetVersion         == NULL ||
         FcCharSetSubtractCount == NULL) {/* problem with the library: return.*/
         closeFontConfig(libfontconfig, JNI_FALSE);
@@ -967,6 +972,7 @@ Java_sun_font_FontConfigManager_getFontConfig
         FcChar8 **family, **styleStr, **fullname, **file;
         jarray fcFontArr = NULL;
         FcCharSet *unionCharset = NULL;
+        FcCharSet *prevUnionCharset = NULL;
 
         fcCompFontObj = (*env)->GetObjectArrayElement(env, fcCompFontArray, i);
         fcNameStr =
@@ -1080,6 +1086,9 @@ Java_sun_font_FontConfigManager_getFontConfig
                 free(file);
                 (*FcPatternDestroy)(pattern);
                 (*FcFontSetDestroy)(fontset);
+                if (prevUnionCharset != NULL) {
+                    (*FcCharSetDestroy)(prevUnionCharset);
+                }
                 closeFontConfig(libfontconfig, JNI_FALSE);
                 if (locale) {
                     (*env)->ReleaseStringUTFChars(env, localeStr, (const char*)locale);
@@ -1101,6 +1110,10 @@ Java_sun_font_FontConfigManager_getFontConfig
                 if ((*FcCharSetSubtractCount)(charset, unionCharset)
                     > minGlyphs) {
                     unionCharset = (* FcCharSetUnion)(unionCharset, charset);
+                    if (prevUnionCharset != NULL) {
+                      (*FcCharSetDestroy)(prevUnionCharset);
+                    }
+                    prevUnionCharset = unionCharset;
                 } else {
                     continue;
                 }
@@ -1119,6 +1132,11 @@ Java_sun_font_FontConfigManager_getFontConfig
             }
         }
 
+        // Release last instance of CharSet union
+        if (prevUnionCharset != NULL) {
+          (*FcCharSetDestroy)(prevUnionCharset);
+        }
+
         /* Once we get here 'fontCount' is the number of returned fonts
          * we actually want to use, so we create 'fcFontArr' of that length.
          * The non-null entries of "family[]" etc are those fonts.