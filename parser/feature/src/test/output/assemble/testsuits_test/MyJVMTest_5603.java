public class MyJVMTest_5603 {

    static int ch = 0;

    boolean isCntrl(int ch) {
        return Character.getType(ch) == Character.CONTROL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5603().isCntrl(ch));
    }
}
