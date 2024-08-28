@@ -299,6 +299,33 @@ awt_fill_imgcv(ImgConvertFcn **array, int mask, int value, ImgConvertFcn fcn)
 }
 
 #ifndef HEADLESS
+void cleanup_graphics_config_data(AwtGraphicsConfigDataPtr awt_data) {
+    if (awt_data->awtImage != NULL) {
+        free(awt_data->awtImage);
+        awt_data->awtImage = NULL;
+    }
+
+    if (awt_data->color_data != NULL) {
+        if (awt_data->color_data->img_clr_tbl != NULL) {
+            free(awt_data->color_data->img_clr_tbl);
+        }
+        if (awt_data->color_data->awt_icmLUT2Colors != NULL) {
+            free(awt_data->color_data->awt_icmLUT2Colors);
+        }
+        if (awt_data->color_data->awt_icmLUT != NULL) {
+            free(awt_data->color_data->awt_icmLUT);
+        }
+        if (awt_data->color_data->awt_Colors != NULL) {
+            free(awt_data->color_data->awt_Colors);
+        }
+        if (awt_data->color_data->img_grays != NULL) {
+            free(awt_data->color_data->img_grays);
+        }
+        free(awt_data->color_data);
+        awt_data->color_data = NULL;
+    }
+}
+
 /*
  * called from X11Server_create() in xlib.c
  */
@@ -320,6 +347,9 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
     char *forcemono;
     char *forcegray;
 
+    // Clean up awt_data for reuse, avoid memory leak
+    cleanup_graphics_config_data(awt_data);
+
     make_uns_ordered_dither_array(img_oda_alpha, 256);
 
 
@@ -495,7 +525,7 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
                        OrdColorDcmOpqUnsImageConvert);
 #endif /* NEED_IMAGE_CONVERT */
     } else {
-        free (awt_data->awtImage);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
 
@@ -510,14 +540,14 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
     }
 
     if (awt_data->awt_num_colors > paletteSize) {
-        free(awt_data->awtImage);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
 
     /* Allocate ColorData structure */
     awt_data->color_data = ZALLOC (_ColorData);
     if (awt_data->color_data == NULL) {
-        free(awt_data->awtImage);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
 
@@ -538,8 +568,7 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
     awt_data->color_data->awt_Colors =
         (ColorEntry *)calloc(paletteSize, sizeof (ColorEntry));
     if (awt_data->color_data->awt_Colors == NULL) {
-        free(awt_data->awtImage);
-        free(awt_data->color_data);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
 
@@ -616,8 +645,7 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
         awt_data->color_data->img_grays =
             (unsigned char *)calloc(256, sizeof(unsigned char));
         if ( awt_data->color_data->img_grays == NULL) {
-            free(awt_data->awtImage);
-            free(awt_data->color_data);
+            cleanup_graphics_config_data(awt_data);
             return 0;
         }
         for (g = 0; g < 256; g++) {
@@ -764,10 +792,10 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
         (unsigned char *)calloc(LOOKUPSIZE * LOOKUPSIZE * LOOKUPSIZE,
                                 sizeof(unsigned char));
     if (awt_data->color_data->img_clr_tbl == NULL) {
-        free(awt_data->awtImage);
-        free(awt_data->color_data);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
+
     img_makePalette(cmapsize, k, LOOKUPSIZE, 50, 250,
                     allocatedColorsNum, TRUE, reds, greens, blues,
                     awt_data->color_data->img_clr_tbl);
@@ -817,8 +845,7 @@ awt_allocate_colors(AwtGraphicsConfigDataPtr awt_data)
         (unsigned char *)calloc(paletteSize, sizeof (unsigned char));
     awt_data->color_data->awt_icmLUT = (int *)calloc(paletteSize, sizeof(int));
     if (awt_data->color_data->awt_icmLUT2Colors == NULL || awt_data->color_data->awt_icmLUT == NULL) {
-        free(awt_data->awtImage);
-        free(awt_data->color_data);
+        cleanup_graphics_config_data(awt_data);
         return 0;
     }
 