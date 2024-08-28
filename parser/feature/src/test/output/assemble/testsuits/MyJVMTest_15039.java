public class MyJVMTest_15039 {

    static int ch = 0;

    boolean isCntrl(int ch) {
        return Character.getType(ch) == Character.CONTROL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15039().isCntrl(ch));
    }
}
