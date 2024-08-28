import java.io.File;
import java.net.URI;

public class MyJVMTest_3379 {

    static String dirParam1Param1 = "Onn@kIU{bM";

    static URI dirParam1 = new URI(dirParam1Param1);

    static File dir = new File(dirParam1);

    static String name = "CP-lyc':{:";

    String path(File dir, String name) {
        return new File(dir, name).getPath();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3379().path(dir, name));
    }
}
