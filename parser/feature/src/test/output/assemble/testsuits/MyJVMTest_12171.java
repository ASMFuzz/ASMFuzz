public class MyJVMTest_12171 {

    static int i1 = 2;

    static int i2 = -983042598;

    int addIntegers(int i1, int i2) {
        return i1 + i2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12171().addIntegers(i1, i2));
    }
}
