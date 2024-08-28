@@ -728,6 +728,11 @@ public Iterator<ImageTypeSpecifier> getImageTypes(int imageIndex) throws IIOExce
                             extraSamples,
                             colorMap);
 
+            if (itsRaw.getColorModel().hasAlpha() &&
+                    getCompression() == BaselineTIFFTagSet.COMPRESSION_JPEG) {
+                throw new IIOException("JPEG compressed tiles with alpha channel are not supported.");
+            }
+
             // Check for an ICCProfile field.
             TIFFField iccProfileField
                     = imageMetadata.getTIFFField(BaselineTIFFTagSet.TAG_ICC_PROFILE);