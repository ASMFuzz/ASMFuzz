public class MyJVMTest_5211 {

    static int x = 9;

    int signExtractInt3(int x) {
        return (x >> 31) >>> 31;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5211().signExtractInt3(x));
    }
}
