@@ -77,6 +77,16 @@ public static Map<String, String> initProperties() {
             putIfAbsent(props, "file.encoding", fileEncoding);
         }
 
+        // "stdout/err.encoding", prepared for System.out/err. For compatibility
+        // purposes, substitute them with "sun.*" if they don't exist. If "sun.*" aren't
+        // available either, fall back to "native.encoding".
+        putIfAbsent(props, "stdout.encoding", props.getOrDefault("sun.stdout.encoding",
+                raw.propDefault(Raw._stdout_encoding_NDX)));
+        putIfAbsent(props, "stdout.encoding", nativeEncoding);
+        putIfAbsent(props, "stderr.encoding", props.getOrDefault("sun.stderr.encoding",
+                raw.propDefault(Raw._stderr_encoding_NDX)));
+        putIfAbsent(props, "stderr.encoding", nativeEncoding);
+
         // Use platform values if not overridden by a commandline -Dkey=value
         // In no particular order
         putIfAbsent(props, "os.name", raw.propDefault(Raw._os_name_NDX));
@@ -100,8 +110,6 @@ public static Map<String, String> initProperties() {
         putIfAbsent(props, "sun.arch.abi", raw.propDefault(Raw._sun_arch_abi_NDX));
         putIfAbsent(props, "sun.arch.data.model", raw.propDefault(Raw._sun_arch_data_model_NDX));
         putIfAbsent(props, "sun.os.patch.level", raw.propDefault(Raw._sun_os_patch_level_NDX));
-        putIfAbsent(props, "sun.stdout.encoding", raw.propDefault(Raw._sun_stdout_encoding_NDX));
-        putIfAbsent(props, "sun.stderr.encoding", raw.propDefault(Raw._sun_stderr_encoding_NDX));
         putIfAbsent(props, "sun.io.unicode.encoding", raw.propDefault(Raw._sun_io_unicode_encoding_NDX));
         putIfAbsent(props, "sun.cpu.isalist", raw.propDefault(Raw._sun_cpu_isalist_NDX));
         putIfAbsent(props, "sun.cpu.endian", raw.propDefault(Raw._sun_cpu_endian_NDX));
@@ -218,16 +226,16 @@ public static class Raw {
         @Native private static final int _socksNonProxyHosts_NDX = 1 + _path_separator_NDX;
         @Native private static final int _socksProxyHost_NDX = 1 + _socksNonProxyHosts_NDX;
         @Native private static final int _socksProxyPort_NDX = 1 + _socksProxyHost_NDX;
-        @Native private static final int _sun_arch_abi_NDX = 1 + _socksProxyPort_NDX;
+        @Native private static final int _stderr_encoding_NDX = 1 + _socksProxyPort_NDX;
+        @Native private static final int _stdout_encoding_NDX = 1 + _stderr_encoding_NDX;
+        @Native private static final int _sun_arch_abi_NDX = 1 + _stdout_encoding_NDX;
         @Native private static final int _sun_arch_data_model_NDX = 1 + _sun_arch_abi_NDX;
         @Native private static final int _sun_cpu_endian_NDX = 1 + _sun_arch_data_model_NDX;
         @Native private static final int _sun_cpu_isalist_NDX = 1 + _sun_cpu_endian_NDX;
         @Native private static final int _sun_io_unicode_encoding_NDX = 1 + _sun_cpu_isalist_NDX;
         @Native private static final int _sun_jnu_encoding_NDX = 1 + _sun_io_unicode_encoding_NDX;
         @Native private static final int _sun_os_patch_level_NDX = 1 + _sun_jnu_encoding_NDX;
-        @Native private static final int _sun_stderr_encoding_NDX = 1 + _sun_os_patch_level_NDX;
-        @Native private static final int _sun_stdout_encoding_NDX = 1 + _sun_stderr_encoding_NDX;
-        @Native private static final int _user_dir_NDX = 1 + _sun_stdout_encoding_NDX;
+        @Native private static final int _user_dir_NDX = 1 + _sun_os_patch_level_NDX;
         @Native private static final int _user_home_NDX = 1 + _user_dir_NDX;
         @Native private static final int _user_name_NDX = 1 + _user_home_NDX;
         @Native private static final int FIXED_LENGTH = 1 + _user_name_NDX;