import java.nio.file.Path;

public class MyJVMTest_16848 {

    static String expected = "P=pjXapYF4";

    int getExitCode() {
        return exitCode;
    }

    String getMessage() {
        return message;
    }

    Path getFile() {
        return imageFile;
    }

    static int exitCode = -498434664;

    static String message = "C{]5,@+Bi/";

    static Path imageFile = null;

    String assertFailure(String expected) {
        if (getExitCode() == 0) {
            System.err.println(getMessage());
            throw new AssertionError("Failure expected: " + getFile());
        }
        if (getExitCode() != 1 && getExitCode() != 2) {
            System.err.println(getMessage());
            throw new AssertionError("Abnormal exit: " + getFile());
        }
        if (expected != null) {
            if (expected.isEmpty()) {
                throw new AssertionError("Expected error is empty");
            }
            if (!getMessage().matches(expected) && !getMessage().contains(expected)) {
                System.err.println(getMessage());
                throw new AssertionError("Output does not fit regexp: " + expected);
            }
        }
        System.err.println("Failed as expected. " + (expected != null ? expected : ""));
        System.err.println(getMessage());
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16848().assertFailure(expected);
    }
}
