import java.io.File;

public class MyJVMTest_10117 {

    static String fileName = "report.xml";

    void deleteReportDocument() {
        final File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10117().deleteReportDocument();
    }
}
