public class MyJVMTest_15869 {

    int getVersion() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15869().getVersion());
    }
}
