public class MyJVMTest_12854 {

    Long foobar() {
        return 0L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12854().foobar());
    }
}
