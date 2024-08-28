public class MyJVMTest_14628 {

    static int x = -1618044816;

    int signExtractInt3(int x) {
        return (x >> 31) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14628().signExtractInt3(x));
    }
}
