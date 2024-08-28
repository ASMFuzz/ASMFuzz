public class MyJVMTest_5213 {

    static OldFDBigIntForTest other = null;

    static int nWords = 7;

    static int[] data = {0,0,2139317946,8,7,1,1742291296,0,0,708677538};

    int cmp(OldFDBigIntForTest other) {
        int i;
        if (this.nWords > other.nWords) {
            int j = other.nWords - 1;
            for (i = this.nWords - 1; i > j; i--) if (this.data[i] != 0)
                return 1;
        } else if (this.nWords < other.nWords) {
            int j = this.nWords - 1;
            for (i = other.nWords - 1; i > j; i--) if (other.data[i] != 0)
                return -1;
        } else {
            i = this.nWords - 1;
        }
        for (; i > 0; i--) if (this.data[i] != other.data[i])
            break;
        int a = this.data[i];
        int b = other.data[i];
        if (a < 0) {
            if (b < 0) {
                return a - b;
            } else {
                return 1;
            }
        } else {
            if (b < 0) {
                return -1;
            } else {
                return a - b;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5213().cmp(other));
    }
}
