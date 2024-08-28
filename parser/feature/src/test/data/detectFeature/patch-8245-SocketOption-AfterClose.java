@@ -105,6 +105,8 @@ static Map<SocketOption<?>,List<Object>> optionValueMap() {
             map.put((SocketOption<?>)field.get(null), listOf(10, 100));
             field = c.getField("SO_INCOMING_NAPI_ID");
             map.put((SocketOption<?>)field.get(null), listOf(RO));
+            field = c.getField("IP_DONTFRAGMENT");
+            map.put((SocketOption<?>)field.get(null), listOf(TRUE, FALSE));
         } catch (ClassNotFoundException e) {
             // ignore, jdk.net module not present
         } catch (ReflectiveOperationException e) {