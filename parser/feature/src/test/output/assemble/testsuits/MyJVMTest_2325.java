public class MyJVMTest_2325 {

    static int row = 9;

    static int col = -186933343;

    boolean isCellEditable(int row, int col) {
        return col != 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2325().isCellEditable(row, col));
    }
}
