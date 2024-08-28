public class MyJVMTest_15137 {

    long getA() {
        return 7L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15137().getA());
    }
}
