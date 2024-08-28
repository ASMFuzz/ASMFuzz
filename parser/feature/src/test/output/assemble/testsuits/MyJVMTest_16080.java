public class MyJVMTest_16080 {

    static int r = 1449897425;

    static int c = 1347656803;

    static String value = "'BL6cgi*`u";

    Object getValueAt(int r, int c) {
        return "Some Value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16080().getValueAt(r, c));
    }
}
