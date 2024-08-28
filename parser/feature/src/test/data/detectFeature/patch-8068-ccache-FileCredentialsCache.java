@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -89,12 +89,7 @@ public static synchronized FileCredentialsCache acquireInstance(
             }
             fcc.load(cacheName);
             return fcc;
-        } catch (IOException e) {
-            // we don't handle it now, instead we return a null at the end.
-            if (DEBUG) {
-                e.printStackTrace();
-            }
-        } catch (KrbException e) {
+        } catch (IOException | KrbException e) {
             // we don't handle it now, instead we return a null at the end.
             if (DEBUG) {
                 e.printStackTrace();
@@ -119,9 +114,7 @@ static synchronized FileCredentialsCache New(PrincipalName principal,
             fcc.init(principal, cacheName);
             return fcc;
         }
-        catch (IOException e) {
-        }
-        catch (KrbException e) {
+        catch (IOException | KrbException e) {
         }
         return null;
     }
@@ -133,15 +126,10 @@ static synchronized FileCredentialsCache New(PrincipalName principal) {
             fcc.init(principal, cacheName);
             return fcc;
         }
-        catch (IOException e) {
-            if (DEBUG) {
-                e.printStackTrace();
-            }
-        } catch (KrbException e) {
+        catch (IOException | KrbException e) {
             if (DEBUG) {
                 e.printStackTrace();
             }
-
         }
         return null;
     }