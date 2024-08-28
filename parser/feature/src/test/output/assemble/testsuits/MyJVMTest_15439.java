public class MyJVMTest_15439 {

    static int i = 6;

    double sqrtAdd(int i) {
        return 1.0 + Math.sqrt(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15439().sqrtAdd(i));
    }
}
