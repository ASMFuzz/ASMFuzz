@@ -768,9 +768,14 @@ public void startElement(String uri, String localName, String qName, Attributes
         case "dateFormatItem":
             {
                 // for FormatData
-                prefix = (currentCalendarType == null) ? "" : currentCalendarType.keyElementName();
-                pushStringEntry(qName, attributes,
-                        prefix + Bundle.DATEFORMATITEM_KEY_PREFIX + attributes.getValue("id"));
+                if (currentCalendarType != null) {
+                    var skeleton = attributes.getValue("id");
+                    CLDRConverter.availableSkeletons.add(skeleton);
+                    pushStringEntry(qName, attributes,
+                            currentCalendarType.keyElementName() + Bundle.DATEFORMATITEM_KEY_PREFIX + skeleton);
+                } else {
+                    pushIgnoredContainer(qName);
+                }
             }
             break;
 