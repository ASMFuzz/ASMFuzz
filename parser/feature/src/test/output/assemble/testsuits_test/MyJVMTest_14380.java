public class MyJVMTest_14380 {

    static int current = 1910533956;

    static long BASE = 1003001;

    int nextInt() {
        current = (int) ((long) current * current % BASE - 1);
        return current;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14380().nextInt());
    }
}
