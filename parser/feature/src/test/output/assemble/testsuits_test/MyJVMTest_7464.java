public class MyJVMTest_7464 {

    static int src1 = 2040829271;

    int tzcntl(int src1) {
        return Integer.numberOfTrailingZeros(src1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7464().tzcntl(src1));
    }
}
