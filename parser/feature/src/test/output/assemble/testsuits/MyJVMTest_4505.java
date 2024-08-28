public class MyJVMTest_4505 {

    static int x = 1131891299;

    int signExtractInt1(int x) {
        return (x >> 1) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4505().signExtractInt1(x));
    }
}
