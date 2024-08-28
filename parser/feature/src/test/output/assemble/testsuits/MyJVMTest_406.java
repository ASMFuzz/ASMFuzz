import java.io.File;
import java.io.PrintWriter;

public class MyJVMTest_406 {

    static String dbgFile = "[<IqjHIfd|";

    String handleOnlyKeepDebug(String dbgFile) throws Exception {
        try (PrintWriter pw = new PrintWriter(new File(dbgFile))) {
            pw.println("Fake objcopy debug info file");
        }
        System.out.println("DEBUG: wrote fake debug file " + dbgFile);
        return dbgFile;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_406().handleOnlyKeepDebug(dbgFile);
    }
}
