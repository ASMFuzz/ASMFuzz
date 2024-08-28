import java.nio.file.Path;

public class MyJVMTest_3328 {

    int getExitCode() {
        return exitCode;
    }

    String getMessage() {
        return message;
    }

    Path getFile() {
        return imageFile;
    }

    static int exitCode = 2;

    static String message = "T]}|S|$/>N";

    static Path imageFile = null;

    Path assertSuccess() {
        if (getExitCode() != 0) {
            System.err.println(getMessage());
            throw new AssertionError("Unexpected failure: " + getExitCode());
        }
        return getFile();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3328().assertSuccess());
    }
}
