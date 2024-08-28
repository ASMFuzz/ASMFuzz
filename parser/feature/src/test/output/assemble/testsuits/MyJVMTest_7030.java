public class MyJVMTest_7030 {

    static int i = 1328392847;

    int simple(int i) {
        Integer ib = new Integer(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7030().simple(i));
    }
}
