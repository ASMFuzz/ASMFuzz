public class MyJVMTest_11414 {

    static int v = -348731565;

    static int min = 0;

    static int max = -66820613;

    Object save() {
        return new Integer(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11414().save());
    }
}
