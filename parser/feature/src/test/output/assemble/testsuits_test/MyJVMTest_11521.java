import java.time.ZoneId;
import java.time.zone.ZoneRules;

public class MyJVMTest_11521 {

    static String zoneId = "($a/=>.5Ee";

    static boolean forCaching = true;

    ZoneRules provideRules(String zoneId, boolean forCaching) {
        return ZoneId.of("UTC").getRules();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11521().provideRules(zoneId, forCaching));
    }
}
