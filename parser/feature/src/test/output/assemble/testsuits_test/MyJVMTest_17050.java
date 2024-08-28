public class MyJVMTest_17050 {

    static int row = 0;

    static int col = 6;

    Object getValueAt(int row, int col) {
        return " ";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17050().getValueAt(row, col));
    }
}
