public class MyJVMTest_17000 {

    static int src1 = -254631851;

    int tzcntl(int src1) {
        return Integer.numberOfTrailingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17000().tzcntl(src1));
    }
}
