public class MyJVMTest_8468 {

    int not_inlined() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8468().not_inlined());
    }
}
