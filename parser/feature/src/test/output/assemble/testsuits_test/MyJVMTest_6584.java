public class MyJVMTest_6584 {

    static int r = 0;

    static int c = 0;

    static String value = "fO5([06Bl7";

    Object getValueAt(int r, int c) {
        return "Some Value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6584().getValueAt(r, c));
    }
}
