@@ -2325,7 +2325,7 @@ public MBeanNotificationInfo[] getNotificationInfo() {
            (ModelMBeanNotificationInfo[])modelMBeanInfo.getNotifications();
 
         // Length of the returned list of notification infos:
-        //    length of user suplied list + possibly 1 for GENERIC, +
+        //    length of user supplied list + possibly 1 for GENERIC, +
         //    possibly 1 for ATTRIBUTE_CHANGE
         //    (bug 4744667)
         final int len = ((currInfo==null?0:currInfo.length) +