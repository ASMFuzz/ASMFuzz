import java.security.Provider;
import java.security.Security;

public class MyJVMTest_14219 {

    static Provider[] oldProviders = {null,null,null,null,null,null,null,null,null,null};

    void restore() {
        Provider[] newProviders = Security.getProviders();
        for (Provider p : newProviders) {
            Security.removeProvider(p.getName());
        }
        for (Provider p : oldProviders) {
            Security.addProvider(p);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14219().restore();
    }
}
