public class MyJVMTest_16061 {

    static B strategy = null;

    static int count = 7;

    A m(B strategy) {
        count++;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16061().m(strategy));
    }
}
