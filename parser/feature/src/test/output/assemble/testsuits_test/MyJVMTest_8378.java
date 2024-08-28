public class MyJVMTest_8378 {

    static int privateInstance = 2;

    int privateInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8378().privateInstance());
    }
}
