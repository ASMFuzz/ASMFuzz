public class MyJVMTest_11585 {

    static int row = 4;

    static int col = 0;

    boolean isCellEditable(int row, int col) {
        return col != 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11585().isCellEditable(row, col));
    }
}
