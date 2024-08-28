@@ -54,6 +54,9 @@ static const ADAPTER_INFO badHardware[] = {
     // All Intel Chips.
     { 0x8086, ALL_DEVICEIDS, NO_VERSION, OS_ALL },
 
+    // Microsoft Basic Render Driver (as maybe used in VMs such as VirtualBox)
+    { 0x1414, 0x008c, NO_VERSION, OS_ALL },
+
     // ATI Mobility Radeon X1600, X1400, X1450, X1300, X1350
     // Reason: workaround for 6613066, 6687166
     // X1300 (four sub ids)