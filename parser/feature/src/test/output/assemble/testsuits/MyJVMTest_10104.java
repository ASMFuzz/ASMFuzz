import java.io.File;

public class MyJVMTest_10104 {

    static String file = "1E1qIcnR)g";

    String checkRead(String file) {
        if (file.endsWith("log" + File.separatorChar + "Logfile.6")) {
            System.out.println("reading file: " + file + " simulating log failure");
            throw new SecurityException("simulating log failure");
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10104().checkRead(file);
    }
}
