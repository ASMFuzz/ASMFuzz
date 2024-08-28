public class MyJVMTest_9479 {

    static int i1 = 3;

    static int i2 = 7;

    boolean similar(int i1, int i2) {
        return Math.abs(i2 - i1) < 6;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9479().similar(i1, i2));
    }
}
