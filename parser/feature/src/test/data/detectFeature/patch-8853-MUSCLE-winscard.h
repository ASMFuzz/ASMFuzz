@@ -49,75 +49,74 @@ extern "C"
 #define PCSC_API
 #endif
 
-      PCSC_API LONG SCardEstablishContext(DWORD dwScope,
-            /*@null@*/ LPCVOID pvReserved1, /*@null@*/ LPCVOID pvReserved2,
-            /*@out@*/ LPSCARDCONTEXT phContext);
+    PCSC_API LONG SCardEstablishContext(DWORD dwScope,
+        /*@null@*/ LPCVOID pvReserved1, /*@null@*/ LPCVOID pvReserved2,
+        /*@out@*/ LPSCARDCONTEXT phContext);
 
-      PCSC_API LONG SCardReleaseContext(SCARDCONTEXT hContext);
+    PCSC_API LONG SCardReleaseContext(SCARDCONTEXT hContext);
 
-      PCSC_API LONG SCardIsValidContext(SCARDCONTEXT hContext);
+    PCSC_API LONG SCardIsValidContext(SCARDCONTEXT hContext);
 
-      PCSC_API LONG SCardConnect(SCARDCONTEXT hContext,
-            LPCSTR szReader,
-            DWORD dwShareMode,
-            DWORD dwPreferredProtocols,
-            /*@out@*/ LPSCARDHANDLE phCard, /*@out@*/ LPDWORD pdwActiveProtocol);
+    PCSC_API LONG SCardConnect(SCARDCONTEXT hContext,
+        LPCSTR szReader,
+        DWORD dwShareMode,
+        DWORD dwPreferredProtocols,
+        /*@out@*/ LPSCARDHANDLE phCard, /*@out@*/ LPDWORD pdwActiveProtocol);
 
-      PCSC_API LONG SCardReconnect(SCARDHANDLE hCard,
-            DWORD dwShareMode,
-            DWORD dwPreferredProtocols,
-            DWORD dwInitialization, /*@out@*/ LPDWORD pdwActiveProtocol);
+    PCSC_API LONG SCardReconnect(SCARDHANDLE hCard,
+        DWORD dwShareMode,
+        DWORD dwPreferredProtocols,
+        DWORD dwInitialization, /*@out@*/ LPDWORD pdwActiveProtocol);
 
-      PCSC_API LONG SCardDisconnect(SCARDHANDLE hCard, DWORD dwDisposition);
+    PCSC_API LONG SCardDisconnect(SCARDHANDLE hCard, DWORD dwDisposition);
 
-      PCSC_API LONG SCardBeginTransaction(SCARDHANDLE hCard);
+    PCSC_API LONG SCardBeginTransaction(SCARDHANDLE hCard);
 
-      PCSC_API LONG SCardEndTransaction(SCARDHANDLE hCard, DWORD dwDisposition);
+    PCSC_API LONG SCardEndTransaction(SCARDHANDLE hCard, DWORD dwDisposition);
 
-      PCSC_API LONG SCardStatus(SCARDHANDLE hCard,
-            /*@null@*/ /*@out@*/ LPSTR mszReaderName,
-            /*@null@*/ /*@out@*/ LPDWORD pcchReaderLen,
-            /*@null@*/ /*@out@*/ LPDWORD pdwState,
-            /*@null@*/ /*@out@*/ LPDWORD pdwProtocol,
-            /*@null@*/ /*@out@*/ LPBYTE pbAtr,
-            /*@null@*/ /*@out@*/ LPDWORD pcbAtrLen);
+    PCSC_API LONG SCardStatus(SCARDHANDLE hCard,
+        /*@null@*/ /*@out@*/ LPSTR mszReaderName,
+        /*@null@*/ /*@out@*/ LPDWORD pcchReaderLen,
+        /*@null@*/ /*@out@*/ LPDWORD pdwState,
+        /*@null@*/ /*@out@*/ LPDWORD pdwProtocol,
+        /*@null@*/ /*@out@*/ LPBYTE pbAtr,
+        /*@null@*/ /*@out@*/ LPDWORD pcbAtrLen);
 
-      PCSC_API LONG SCardGetStatusChange(SCARDCONTEXT hContext,
-            DWORD dwTimeout,
-            SCARD_READERSTATE *rgReaderStates, DWORD cReaders);
+    PCSC_API LONG SCardGetStatusChange(SCARDCONTEXT hContext,
+        DWORD dwTimeout,
+        SCARD_READERSTATE *rgReaderStates, DWORD cReaders);
 
-      PCSC_API LONG SCardControl(SCARDHANDLE hCard, DWORD dwControlCode,
-            LPCVOID pbSendBuffer, DWORD cbSendLength,
-            /*@out@*/ LPVOID pbRecvBuffer, DWORD cbRecvLength,
-            LPDWORD lpBytesReturned);
+    PCSC_API LONG SCardControl(SCARDHANDLE hCard, DWORD dwControlCode,
+        LPCVOID pbSendBuffer, DWORD cbSendLength,
+        /*@out@*/ LPVOID pbRecvBuffer, DWORD cbRecvLength,
+        LPDWORD lpBytesReturned);
 
-      PCSC_API LONG SCardTransmit(SCARDHANDLE hCard,
-            const SCARD_IO_REQUEST *pioSendPci,
-            LPCBYTE pbSendBuffer, DWORD cbSendLength,
-            /*@out@*/ SCARD_IO_REQUEST *pioRecvPci,
-            /*@out@*/ LPBYTE pbRecvBuffer, LPDWORD pcbRecvLength);
+    PCSC_API LONG SCardTransmit(SCARDHANDLE hCard,
+        const SCARD_IO_REQUEST *pioSendPci,
+        LPCBYTE pbSendBuffer, DWORD cbSendLength,
+        /*@out@*/ SCARD_IO_REQUEST *pioRecvPci,
+        /*@out@*/ LPBYTE pbRecvBuffer, LPDWORD pcbRecvLength);
 
-      PCSC_API LONG SCardListReaderGroups(SCARDCONTEXT hContext,
-            /*@out@*/ LPSTR mszGroups, LPDWORD pcchGroups);
+    PCSC_API LONG SCardListReaderGroups(SCARDCONTEXT hContext,
+        /*@out@*/ LPSTR mszGroups, LPDWORD pcchGroups);
 
-      PCSC_API LONG SCardListReaders(SCARDCONTEXT hContext,
-            /*@null@*/ /*@out@*/ LPCSTR mszGroups,
-            /*@null@*/ /*@out@*/ LPSTR mszReaders,
-            /*@out@*/ LPDWORD pcchReaders);
+    PCSC_API LONG SCardListReaders(SCARDCONTEXT hContext,
+        /*@null@*/ /*@out@*/ LPCSTR mszGroups,
+        /*@null@*/ /*@out@*/ LPSTR mszReaders,
+        /*@out@*/ LPDWORD pcchReaders);
 
-      PCSC_API LONG SCardFreeMemory(SCARDCONTEXT hContext, LPCVOID pvMem);
+    PCSC_API LONG SCardFreeMemory(SCARDCONTEXT hContext, LPCVOID pvMem);
 
-      PCSC_API LONG SCardCancel(SCARDCONTEXT hContext);
+    PCSC_API LONG SCardCancel(SCARDCONTEXT hContext);
 
-      PCSC_API LONG SCardGetAttrib(SCARDHANDLE hCard, DWORD dwAttrId,
-            /*@out@*/ LPBYTE pbAttr, LPDWORD pcbAttrLen);
+    PCSC_API LONG SCardGetAttrib(SCARDHANDLE hCard, DWORD dwAttrId,
+        /*@out@*/ LPBYTE pbAttr, LPDWORD pcbAttrLen);
 
-      PCSC_API LONG SCardSetAttrib(SCARDHANDLE hCard, DWORD dwAttrId,
-            LPCBYTE pbAttr, DWORD cbAttrLen);
+    PCSC_API LONG SCardSetAttrib(SCARDHANDLE hCard, DWORD dwAttrId,
+        LPCBYTE pbAttr, DWORD cbAttrLen);
 
 #ifdef __cplusplus
 }
 #endif
 
 #endif
-