public class MyJVMTest_16847 {

    static int i = 1;

    double sqrtAdd(int i) {
        return 2.0 + Math.sqrt(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16847().sqrtAdd(i));
    }
}
