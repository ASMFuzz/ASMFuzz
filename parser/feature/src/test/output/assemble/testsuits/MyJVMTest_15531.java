public class MyJVMTest_15531 {

    static int i = -714308850;

    Integer foob(int i) {
        return Integer.valueOf(i);
    }

    int simplef(int i) {
        Integer ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15531().simplef(i));
    }
}
