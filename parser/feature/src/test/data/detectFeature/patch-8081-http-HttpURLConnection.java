@@ -1465,17 +1465,14 @@ private OutputStream getOutputStream0() throws IOException {
                 }
                 return poster;
             }
-        } catch (RuntimeException e) {
-            disconnectInternal();
-            throw e;
         } catch (ProtocolException e) {
             // Save the response code which may have been set while enforcing
             // the 100-continue. disconnectInternal() forces it to -1
             int i = responseCode;
             disconnectInternal();
             responseCode = i;
             throw e;
-        } catch (IOException e) {
+        } catch (RuntimeException | IOException e) {
             disconnectInternal();
             throw e;
         }