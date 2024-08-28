public class MyJVMTest_6073 {

    static int i = 0;

    Integer foob(int i) {
        return Integer.valueOf(i);
    }

    int simplef(int i) {
        Integer ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6073().simplef(i));
    }
}
