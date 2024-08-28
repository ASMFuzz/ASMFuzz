@@ -1298,6 +1298,7 @@ void X11SD_DisposeXImage(XImage * image) {
 #ifdef MITSHM
         if (image->obdata != NULL) {
             X11SD_DropSharedSegment((XShmSegmentInfo*)image->obdata);
+            free(image->obdata);
             image->obdata = NULL;
         }
 #endif /* MITSHM */