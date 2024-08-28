public class MyJVMTest_16282 {

    static boolean isOpenJ9Status = System.getProperty("java.vm.vendor").contains("OpenJ9");

    boolean isOpenJ9() {
        return isOpenJ9Status;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16282().isOpenJ9());
    }
}
