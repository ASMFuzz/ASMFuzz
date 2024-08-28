public class MyJVMTest_15543 {

    long s_long_method() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15543().s_long_method());
    }
}
