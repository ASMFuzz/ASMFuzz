import javax.security.auth.*;
import javax.security.auth.login.*;
import javax.security.auth.callback.*;
import java.io.File;

public class MyJVMTest_14257 {

    static String TEST = "OptionTest";

    static String URL = "XH_t?[0aPJ";

    static String SPASS_URL = "dVu',BfN6@";

    static String KPASS_URL = "r^[lJIiLMq";

    void init() throws Exception {
        File f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".keystore");
        URL = f.toURI().toURL().toString();
        f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".storePass");
        SPASS_URL = f.toURI().toURL().toString();
        f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".keyPass");
        KPASS_URL = f.toURI().toURL().toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14257().init();
    }
}
