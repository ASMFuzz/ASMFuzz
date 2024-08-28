import java.io.File;

public class MyJVMTest_923 {

    static String file = "wObbHuZ >z";

    String checkRead(String file) {
        if (file.endsWith("log" + File.separatorChar + "Logfile.6")) {
            System.out.println("reading file: " + file + " simulating log failure");
            throw new SecurityException("simulating log failure");
        }
        return file;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_923().checkRead(file);
    }
}
