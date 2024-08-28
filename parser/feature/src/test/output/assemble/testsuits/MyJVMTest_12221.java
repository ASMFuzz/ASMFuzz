public class MyJVMTest_12221 {

    int return_int() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12221().return_int());
    }
}
