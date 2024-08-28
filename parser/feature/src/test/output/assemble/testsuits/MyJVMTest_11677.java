import java.io.*;
import java.util.*;

public class MyJVMTest_11677 {

    void preparePerLocalePackageProperties() {
        final String DEL = File.separator;
        try {
            String dir = System.getProperty("test.classes", ".");
            String[] subdirs = { "", "de", "ja_JP" };
            for (String subdir : subdirs) {
                StringBuilder sb = new StringBuilder();
                sb.append(dir).append(DEL).append("test").append(DEL).append("package");
                if (subdir.length() > 0) {
                    sb.append(DEL).append(subdir);
                }
                File path = new File(sb.toString());
                path.mkdirs();
                File propsfile = new File(path, "Messages.properties");
                OutputStream os = new FileOutputStream(propsfile);
                Properties props = new Properties();
                props.setProperty("data", subdir);
                props.store(os, null);
                System.out.println("Created: " + propsfile);
                os.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't set up per-locale properties", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11677().preparePerLocalePackageProperties();
    }
}
