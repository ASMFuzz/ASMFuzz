@@ -42,8 +42,9 @@ static const char* replace_addr_expr(const char* str)
     std::basic_string<char> tmp1 = std::regex_replace(str, std::regex("0x[0-9a-fA-F]+"), "<addr>");
     // Padding: aarch64
     std::basic_string<char> tmp2 = std::regex_replace(tmp1, std::regex("\\s+<addr>:\\s+\\.inst\\t<addr> ; undefined"), "");
+    std::basic_string<char> tmp3 = std::regex_replace(tmp2, std::regex("\\s+<addr>:\\s+udf\\t#0"), "");
     // Padding: x64
-    std::basic_string<char> red  = std::regex_replace(tmp2, std::regex("\\s+<addr>:\\s+hlt[ \\t]+(?!\\n\\s+;;)"), "");
+    std::basic_string<char> red  = std::regex_replace(tmp3, std::regex("\\s+<addr>:\\s+hlt[ \\t]+(?!\\n\\s+;;)"), "");
 
     return os::strdup(red.c_str());
 }