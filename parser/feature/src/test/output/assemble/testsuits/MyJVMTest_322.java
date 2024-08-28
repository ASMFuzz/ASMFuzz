public class MyJVMTest_322 {

    static int i1 = 8;

    static int i2 = 0;

    boolean similar(int i1, int i2) {
        return Math.abs(i2 - i1) < 6;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_322().similar(i1, i2));
    }
}
