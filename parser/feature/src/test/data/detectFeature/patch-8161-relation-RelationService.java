@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,7 +31,6 @@
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
-import java.util.Iterator;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
@@ -666,10 +665,8 @@ public void addRelation(ObjectName relationObjectName)
         } catch (MBeanException exc1) {
             throw new RuntimeException(
                                      (exc1.getTargetException()).getMessage());
-        } catch (ReflectionException exc2) {
+        } catch (ReflectionException | AttributeNotFoundException exc2) {
             throw new RuntimeException(exc2.getMessage());
-        } catch (AttributeNotFoundException exc3) {
-            throw new RuntimeException(exc3.getMessage());
         }
 
         if (relId == null) {
@@ -690,10 +687,8 @@ public void addRelation(ObjectName relationObjectName)
         } catch (MBeanException exc1) {
             throw new RuntimeException(
                                      (exc1.getTargetException()).getMessage());
-        } catch (ReflectionException exc2) {
+        } catch (ReflectionException | AttributeNotFoundException exc2) {
             throw new RuntimeException(exc2.getMessage());
-        } catch (AttributeNotFoundException exc3) {
-            throw new RuntimeException(exc3.getMessage());
         }
 
         boolean badRelServFlag = false;
@@ -719,10 +714,8 @@ public void addRelation(ObjectName relationObjectName)
         } catch (MBeanException exc1) {
             throw new RuntimeException(
                                      (exc1.getTargetException()).getMessage());
-        }catch (ReflectionException exc2) {
+        }catch (ReflectionException | AttributeNotFoundException exc2) {
             throw new RuntimeException(exc2.getMessage());
-        } catch (AttributeNotFoundException exc3) {
-            throw new RuntimeException(exc3.getMessage());
         }
         if (relTypeName == null) {
             String excMsg = "No relation type provided.";
@@ -1534,10 +1527,8 @@ public void purgeRelations()
                     handleReferenceUnregistration(currRelId,
                                                   unregMBeanName,
                                                   localRoleNameList);
-                } catch (RelationNotFoundException exc1) {
-                    throw new RuntimeException(exc1.getMessage());
-                } catch (RoleNotFoundException exc2) {
-                    throw new RuntimeException(exc2.getMessage());
+                } catch (RelationNotFoundException | RoleNotFoundException exc) {
+                    throw new RuntimeException(exc.getMessage());
                 }
             }
         }
@@ -1846,12 +1837,10 @@ public List<ObjectName> getRole(String relationId,
                     result = invokeResult;
                 else
                     result = new ArrayList<ObjectName>(invokeResult);
-            } catch (InstanceNotFoundException exc1) {
+            } catch (InstanceNotFoundException | ReflectionException exc1) {
                 throw new RuntimeException(exc1.getMessage());
-            } catch (ReflectionException exc2) {
-                throw new RuntimeException(exc2.getMessage());
-            } catch (MBeanException exc3) {
-                Exception wrappedExc = exc3.getTargetException();
+            } catch (MBeanException exc2) {
+                Exception wrappedExc = exc2.getTargetException();
                 if (wrappedExc instanceof RoleNotFoundException) {
                     throw ((RoleNotFoundException)wrappedExc);
                 } else {
@@ -1926,13 +1915,11 @@ public RoleResult getRoles(String relationId,
                                           "getRoles",
                                           params,
                                           signature));
-            } catch (InstanceNotFoundException exc1) {
+            } catch (InstanceNotFoundException | ReflectionException exc1) {
                 throw new RuntimeException(exc1.getMessage());
-            } catch (ReflectionException exc2) {
-                throw new RuntimeException(exc2.getMessage());
-            } catch (MBeanException exc3) {
+            } catch (MBeanException exc2) {
                 throw new
-                    RuntimeException((exc3.getTargetException()).getMessage());
+                    RuntimeException((exc2.getTargetException()).getMessage());
             }
         }
 
@@ -2043,12 +2030,10 @@ public Integer getRoleCardinality(String relationId,
                                           "getRoleCardinality",
                                           params,
                                           signature));
-            } catch (InstanceNotFoundException exc1) {
+            } catch (InstanceNotFoundException | ReflectionException exc1) {
                 throw new RuntimeException(exc1.getMessage());
-            } catch (ReflectionException exc2) {
-                throw new RuntimeException(exc2.getMessage());
-            } catch (MBeanException exc3) {
-                Exception wrappedExc = exc3.getTargetException();
+            } catch (MBeanException exc2) {
+                Exception wrappedExc = exc2.getTargetException();
                 if (wrappedExc instanceof RoleNotFoundException) {
                     throw ((RoleNotFoundException)wrappedExc);
                 } else {
@@ -2148,10 +2133,9 @@ public void setRole(String relationId,
                 myMBeanServer.setAttribute(((ObjectName)relObj),
                                            new Attribute("Role", role));
 
-            } catch (InstanceNotFoundException exc1) {
+            } catch (InstanceNotFoundException | ReflectionException |
+                    AttributeNotFoundException | InvalidAttributeValueException exc1) {
                 throw new RuntimeException(exc1.getMessage());
-            } catch (ReflectionException exc3) {
-                throw new RuntimeException(exc3.getMessage());
             } catch (MBeanException exc2) {
                 Exception wrappedExc = exc2.getTargetException();
                 if (wrappedExc instanceof RoleNotFoundException) {
@@ -2162,10 +2146,6 @@ public void setRole(String relationId,
                     throw new RuntimeException(wrappedExc.getMessage());
 
                 }
-            } catch (AttributeNotFoundException exc4) {
-              throw new RuntimeException(exc4.getMessage());
-            } catch (InvalidAttributeValueException exc5) {
-              throw new RuntimeException(exc5.getMessage());
             }
         }
 
@@ -2244,10 +2224,8 @@ public RoleResult setRoles(String relationId,
                                           "setRoles",
                                           params,
                                           signature));
-            } catch (InstanceNotFoundException exc1) {
+            } catch (InstanceNotFoundException | ReflectionException exc1) {
                 throw new RuntimeException(exc1.getMessage());
-            } catch (ReflectionException exc3) {
-                throw new RuntimeException(exc3.getMessage());
             } catch (MBeanException exc2) {
                 throw new
                     RuntimeException((exc2.getTargetException()).getMessage());
@@ -3287,12 +3265,9 @@ private void initializeMissingRoles(boolean relationBaseFlag,
                 try {
                     relationObj.setRoleInt(role, true, this, false);
 
-                } catch (RoleNotFoundException exc1) {
-                    throw new RuntimeException(exc1.getMessage());
-                } catch (RelationNotFoundException exc2) {
-                    throw new RuntimeException(exc2.getMessage());
-                } catch (RelationTypeNotFoundException exc3) {
-                    throw new RuntimeException(exc3.getMessage());
+                } catch (RoleNotFoundException | RelationTypeNotFoundException |
+                         RelationNotFoundException exc) {
+                    throw new RuntimeException(exc.getMessage());
                 }
 
             } else {
@@ -3317,21 +3292,16 @@ private void initializeMissingRoles(boolean relationBaseFlag,
                     myMBeanServer.setAttribute(relationObjName,
                                                new Attribute("Role", role));
 
-                } catch (InstanceNotFoundException exc1) {
+                } catch (InstanceNotFoundException | InvalidAttributeValueException |
+                         AttributeNotFoundException | ReflectionException exc1) {
                     throw new RuntimeException(exc1.getMessage());
-                } catch (ReflectionException exc3) {
-                    throw new RuntimeException(exc3.getMessage());
                 } catch (MBeanException exc2) {
                     Exception wrappedExc = exc2.getTargetException();
                     if (wrappedExc instanceof InvalidRoleValueException) {
                         throw ((InvalidRoleValueException)wrappedExc);
                     } else {
                         throw new RuntimeException(wrappedExc.getMessage());
                     }
-                } catch (AttributeNotFoundException exc4) {
-                  throw new RuntimeException(exc4.getMessage());
-                } catch (InvalidAttributeValueException exc5) {
-                  throw new RuntimeException(exc5.getMessage());
                 }
             }
         }
@@ -3620,10 +3590,8 @@ private void handleReferenceUnregistration(String relationId,
             try {
                 currRoleInfo = getRoleInfo(currRelTypeName,
                                            currRoleName);
-            } catch (RelationTypeNotFoundException exc1) {
-                throw new RuntimeException(exc1.getMessage());
-            } catch (RoleInfoNotFoundException exc2) {
-                throw new RuntimeException(exc2.getMessage());
+            } catch (RelationTypeNotFoundException | RoleInfoNotFoundException exc) {
+                throw new RuntimeException(exc.getMessage());
             }
 
             // Checks with expected minimum number of elements
@@ -3669,10 +3637,8 @@ private void handleReferenceUnregistration(String relationId,
                                                   currRoleName,
                                                   true,
                                                   this);
-                    } catch (RelationTypeNotFoundException exc3) {
-                        throw new RuntimeException(exc3.getMessage());
-                    } catch (InvalidRoleValueException exc4) {
-                        throw new RuntimeException(exc4.getMessage());
+                    } catch (RelationTypeNotFoundException | InvalidRoleValueException exc) {
+                        throw new RuntimeException(exc.getMessage());
                     }
 
                 } else {
@@ -3692,10 +3658,8 @@ private void handleReferenceUnregistration(String relationId,
                                              "handleMBeanUnregistration",
                                              params,
                                              signature);
-                    } catch (InstanceNotFoundException exc1) {
+                    } catch (InstanceNotFoundException | ReflectionException exc1) {
                         throw new RuntimeException(exc1.getMessage());
-                    } catch (ReflectionException exc3) {
-                        throw new RuntimeException(exc3.getMessage());
                     } catch (MBeanException exc2) {
                         Exception wrappedExc = exc2.getTargetException();
                         throw new RuntimeException(wrappedExc.getMessage());