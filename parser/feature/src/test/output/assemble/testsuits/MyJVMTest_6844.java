public class MyJVMTest_6844 {

    static int rows = 9;

    boolean next(int rows) {
        return rows < 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6844().next(rows));
    }
}
