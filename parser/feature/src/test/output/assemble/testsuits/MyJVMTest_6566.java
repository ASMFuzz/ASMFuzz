public class MyJVMTest_6566 {

    static B strategy = null;

    static int count = 3;

    A m(B strategy) {
        count++;
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6566().m(strategy));
    }
}
