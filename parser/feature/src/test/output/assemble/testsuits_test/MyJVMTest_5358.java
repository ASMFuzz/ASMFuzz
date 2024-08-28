import javax.security.auth.login.*;

public class MyJVMTest_5358 {

    void run() {
        try {
            System.out.println("attempting to access configuration...");
            Configuration config = Configuration.getConfiguration();
            AppConfigurationEntry[] entries = config.getAppConfigurationEntry("Synchronize");
            config.refresh();
            System.out.println("done accessing configuration...");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5358().run();
    }
}
