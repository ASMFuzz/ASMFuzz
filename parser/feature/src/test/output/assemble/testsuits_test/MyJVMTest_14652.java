public class MyJVMTest_14652 {

    static int i = 0;

    static int m = 5;

    static OldFDBigIntForTest other = null;

    static int nWords = 3;

    static int[] data = {-580288063,0,8,3,9,-1611870700,8,6,9,5};

    boolean dataInRangeIsZero(int i, int m, OldFDBigIntForTest other) {
        while (i < m) if (other.data[i++] != 0)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14652().dataInRangeIsZero(i, m, other));
    }
}
