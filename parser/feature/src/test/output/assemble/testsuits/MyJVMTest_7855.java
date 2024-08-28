public class MyJVMTest_7855 {

    static int[] d = { 1, 2, 3, 4 };

    static int i = 1273876247, size = 0;

    static int iter = 5;

    boolean done() {
        return (--iter > 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7855().done());
    }
}
