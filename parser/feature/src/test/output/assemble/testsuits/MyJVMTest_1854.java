public class MyJVMTest_1854 {

    static int src1 = 0;

    static int src2 = -916437585;

    int andnl(int src1, int src2) {
        return ~src1 & src2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1854().andnl(src1, src2));
    }
}
