@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -341,12 +341,8 @@ public void parse(InputSource is) throws IOException, SAXException {
         mPh = PH_BEFORE_DOC;  // before parsing
         try {
             setinp(is);
-        } catch (SAXException saxe) {
-            throw saxe;
-        } catch (IOException ioe) {
-            throw ioe;
-        } catch (RuntimeException rte) {
-            throw rte;
+        } catch (SAXException | IOException | RuntimeException e) {
+            throw e;
         } catch (Exception e) {
             panic(e.toString());
         }
@@ -529,12 +525,8 @@ private void parse() throws SAXException, IOException {
             } while (mPh == PH_DOCELM_MISC);
             mPh = PH_AFTER_DOC;  // parsing is completed
 
-        } catch (SAXException saxe) {
-            throw saxe;
-        } catch (IOException ioe) {
-            throw ioe;
-        } catch (RuntimeException rte) {
-            throw rte;
+        } catch (SAXException | IOException | RuntimeException e) {
+            throw e;
         } catch (Exception e) {
             panic(e.toString());
         } finally {