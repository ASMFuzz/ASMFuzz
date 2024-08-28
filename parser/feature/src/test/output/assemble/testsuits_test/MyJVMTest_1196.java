import java.io.*;
import java.util.*;

public class MyJVMTest_1196 {

    static boolean _verbose = true;

    static boolean _ignoreJarDirectories = false;

    static Globals _instance = null;

    Globals getInstance() {
        if (_instance == null) {
            _instance = new Globals();
            _verbose = (System.getProperty("sun.tools.pack.verify.verbose") == null) ? false : true;
            _ignoreJarDirectories = (System.getProperty("ignoreJarDirectories") == null) ? false : true;
        }
        return _instance;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1196().getInstance());
    }
}
