public class MyJVMTest_2873 {

    static int i1 = 3;

    static int i2 = 9;

    int addIntegers(int i1, int i2) {
        return i1 + i2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2873().addIntegers(i1, i2));
    }
}
