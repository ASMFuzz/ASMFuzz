public class MyJVMTest_2667 {

    static int[] arr = new int[42];

    int testLocal() {
        int[] arr = new int[42];
        try {
            return arr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2667().testLocal());
    }
}
