import java.lang.invoke.*;

public class MyJVMTest_11664 {

    static String[] arr1 = { "K`E6_X<BgH", "N0>8}rw{f`", "q6~3gd3uf-", "i9B @0g\\<K", "~R67a!cxc(", "ai=*&>=YLZ", "O.6%t`G#.1", "T4UDGU:;xx", "fRd;:jh}6;", "%6# y\"K;/W" };

    static String[] arr2 = { "exotB0s7xz", "\"Dsa.W+ (7", "'+v^e?97H0", ";o]^]iJrZ,", "EPf8H7~S,z", "Y]jeUIytM=", "/;$ruJp?Y7", "$ibvvJ+*Q*", "Zz|YSzP]7y", "QJo:HA[Q] " };

    String[] verifyStr(String[] arr1, String[] arr2) {
        if (arr1 == arr2) {
            throw new RuntimeException("Must not be the same");
        }
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Must have the same length");
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                throw new RuntimeException("Fail cloned element not the same: " + i);
            }
            if (!arr1[i].equals(arr2[i])) {
                throw new RuntimeException("Fail cloned element content not the same");
            }
        }
        return arr1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11664().verifyStr(arr1, arr2);
    }
}
