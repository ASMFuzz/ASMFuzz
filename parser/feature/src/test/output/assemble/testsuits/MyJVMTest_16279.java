import java.io.*;

public class MyJVMTest_16279 {

    static String fParam1 = "rnC@\\_=Qaj";

    static String fParam2 = "C(ac^:6<0H";

    static File f = new File(fParam1, fParam2);

    File checkHidden(File f) {
        if (!f.isHidden())
            throw new RuntimeException(f + " should be hidden");
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16279().checkHidden(f);
    }
}
