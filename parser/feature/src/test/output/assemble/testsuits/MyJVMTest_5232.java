public class MyJVMTest_5232 {

    static int i = 0;

    static int m = -1528223318;

    static OldFDBigIntForTest other = null;

    static int nWords = 3;

    static int[] data = {-859232819,0,1,-1514168214,0,0,0,9,9,5};

    boolean dataInRangeIsZero(int i, int m, OldFDBigIntForTest other) {
        while (i < m) if (other.data[i++] != 0)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5232().dataInRangeIsZero(i, m, other));
    }
}
