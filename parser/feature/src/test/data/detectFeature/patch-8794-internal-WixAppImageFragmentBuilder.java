@@ -485,17 +485,11 @@ private String addShortcutComponent(XMLStreamWriter xml, Path launcherPath,
 
         Path shortcutPath = folder.getPath(this).resolve(launcherBasename);
         return addComponent(xml, shortcutPath, Component.Shortcut, unused -> {
-            final Path icoFile = IOUtils.addSuffix(
-                    installedAppImage.destktopIntegrationDirectory().resolve(
-                            launcherBasename), ".ico");
-
             xml.writeAttribute("Name", launcherBasename);
             xml.writeAttribute("WorkingDirectory", INSTALLDIR.toString());
             xml.writeAttribute("Advertise", "no");
-            xml.writeAttribute("IconIndex", "0");
             xml.writeAttribute("Target", String.format("[#%s]",
                     Component.File.idOf(launcherPath)));
-            xml.writeAttribute("Icon", Id.Icon.of(icoFile));
         });
     }
 