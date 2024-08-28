import java.io.File;

public class MyJVMTest_5229 {

    static String file = "@'4XKa?qm[";

    String checkWrite(String file) {
        if (file.endsWith("log" + File.separatorChar + "Snapshot.6")) {
            System.out.println("writing file: " + file + " simulating log failure");
            throw new SecurityException("simulating log failure");
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5229().checkWrite(file);
    }
}
