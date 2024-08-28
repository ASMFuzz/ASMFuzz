import java.io.File;

public class MyJVMTest_12265 {

    String sharedLibraryPathVariableName() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.startsWith("win")) {
            return "PATH";
        } else if (osName.startsWith("mac")) {
            return "DYLD_LIBRARY_PATH";
        } else if (osName.startsWith("aix")) {
            return "LIBPATH";
        } else {
            return "LD_LIBRARY_PATH";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12265().sharedLibraryPathVariableName());
    }
}
