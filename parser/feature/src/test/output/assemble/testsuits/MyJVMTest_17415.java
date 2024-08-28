public class MyJVMTest_17415 {

    static int[] d = { 1, 2, 3, 4 };

    static int i = 5, size = -595626176;

    static int iter = 5;

    boolean done() {
        return (--iter > 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17415().done());
    }
}
