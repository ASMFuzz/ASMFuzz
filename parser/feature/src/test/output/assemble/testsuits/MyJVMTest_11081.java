public class MyJVMTest_11081 {

    static int src1 = 1;

    static int src2 = 3;

    int andnl(int src1, int src2) {
        return ~src1 & src2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11081().andnl(src1, src2));
    }
}
