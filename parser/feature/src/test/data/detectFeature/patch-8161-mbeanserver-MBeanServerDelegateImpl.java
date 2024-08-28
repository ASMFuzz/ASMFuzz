@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -167,12 +167,8 @@ else if (attribute.equals("ImplementationVendor"))
             else
                 throw new AttributeNotFoundException("null");
 
-        } catch (AttributeNotFoundException x) {
+        } catch (AttributeNotFoundException | JMRuntimeException | SecurityException x) {
             throw x;
-        } catch (JMRuntimeException j) {
-            throw j;
-        } catch (SecurityException s) {
-            throw s;
         } catch (Exception x) {
             throw new MBeanException(x,"Failed to get " + attribute);
         }