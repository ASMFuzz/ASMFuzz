import javax.security.auth.*;
import javax.security.auth.login.*;
import javax.security.auth.callback.*;
import java.io.File;

public class MyJVMTest_4857 {

    static String TEST = "OptionTest";

    static String URL = "TKc_fYrH-S";

    static String SPASS_URL = "Ro3?|\"HGO<";

    static String KPASS_URL = "s<M\\,Nf\\fE";

    void init() throws Exception {
        File f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".keystore");
        URL = f.toURI().toURL().toString();
        f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".storePass");
        SPASS_URL = f.toURI().toURL().toString();
        f = new File(System.getProperty("test.src", ".") + File.separatorChar + TEST + ".keyPass");
        KPASS_URL = f.toURI().toURL().toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4857().init();
    }
}
