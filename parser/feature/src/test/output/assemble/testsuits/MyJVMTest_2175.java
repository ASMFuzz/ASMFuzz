public class MyJVMTest_2175 {

    static int privateStatic = 0;

    int privateStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2175().privateStatic());
    }
}
