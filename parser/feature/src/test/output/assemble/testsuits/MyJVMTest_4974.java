public class MyJVMTest_4974 {

    static int current = 448691167;

    static long BASE = 1003001;

    int nextInt() {
        current = (int) ((long) current * current % BASE - 1);
        return current;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4974().nextInt());
    }
}
