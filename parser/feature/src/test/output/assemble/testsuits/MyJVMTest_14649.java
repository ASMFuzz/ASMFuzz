import java.io.File;

public class MyJVMTest_14649 {

    static String file = "9VKsS,~Bu!";

    String checkWrite(String file) {
        if (file.endsWith("log" + File.separatorChar + "Snapshot.6")) {
            System.out.println("writing file: " + file + " simulating log failure");
            throw new SecurityException("simulating log failure");
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14649().checkWrite(file);
    }
}
