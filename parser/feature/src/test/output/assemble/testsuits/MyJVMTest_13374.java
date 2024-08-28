import java.io.File;

public class MyJVMTest_13374 {

    String getJDKRoot() {
        String jdkPath = System.getProperty("test.jdk");
        if (jdkPath == null) {
            throw new RuntimeException("System property 'test.jdk' not set. This property is normally set by jtreg. " + "When running test separately, set this property using '-Dtest.jdk=/path/to/jdk'.");
        }
        return jdkPath;
    }

    File getReleaseFile() throws Exception {
        String jdkPath = getJDKRoot();
        File releaseFile = new File(jdkPath, "release");
        if (!releaseFile.canRead()) {
            throw new Exception("Release file is not readable, or it is absent: " + releaseFile.getCanonicalPath());
        }
        return releaseFile;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13374().getReleaseFile());
    }
}
