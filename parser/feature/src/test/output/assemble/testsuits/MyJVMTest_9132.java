import java.lang.invoke.*;

public class MyJVMTest_9132 {

    static String[] arr1 = { "(~^}!v|Xr,", "7eeE[6]M)U", "aT6DOJy'W\"", "U`AJn;LS9!", "G=Qv41}FIO", "^,z}XoV#\"9", "4\\&;>swjr ", "PJDNtwx)wD", "EPE5y;z]{G", "iR&*{\"ZIeM" };

    static String[] arr2 = { "-j8OkM|[S4", "|,=_cr `yL", "'lN931g`'x", "4_g7/3=FHI", "UJJ]]p8X22", "t5vI5AGDxq", "b~z'7{0blt", "6Z_ORN2P+M", ",1zpd>.\"\\|", "z!}1^aE8MD" };

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
        new MyJVMTest_9132().verifyStr(arr1, arr2);
    }
}
