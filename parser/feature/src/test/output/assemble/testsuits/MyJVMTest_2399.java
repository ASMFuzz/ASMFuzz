import java.lang.invoke.*;

public class MyJVMTest_2399 {

    static String[] arr1 = { "!DT\\X>*r'!", "5y7;x2^[u7", "-H}LDG?_S0", "]9\"H3V)R|A", "]a9znd+6uZ", "gu;C$lhg\\d", "S82sW`6m:m", "~8]zhkYn{;", "$c%o1,wHKl", "G~j) Fe4:K" };

    static String[] arr2 = { "PM?=xyc-Z|", "W 4&v=S#$@", "&fzfh;DNt`", ".@n6%_*l3i", " 4/-1l=:AD", "#Qt1)kL8]v", "e2jgTu] Eo", "Dtipkq`p=O", "QK_2>ReP|.", "Jir8'$f i|" };

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
        new MyJVMTest_2399().verifyStr(arr1, arr2);
    }
}
