public class MyJVMTest_3601 {

    int getReadWrite1() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3601().getReadWrite1());
    }
}
