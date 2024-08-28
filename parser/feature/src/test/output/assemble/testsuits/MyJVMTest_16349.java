public class MyJVMTest_16349 {

    static int rows = 2;

    boolean next(int rows) {
        return rows < 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16349().next(rows));
    }
}
