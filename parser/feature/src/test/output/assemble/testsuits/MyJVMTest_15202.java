public class MyJVMTest_15202 {

    int returnOne() {
        String str = null;
        str.equals("a");
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15202().returnOne());
    }
}
