public class MyJVMTest_9784 {

    static boolean isPasswordField = true;

    static boolean drawLine = false;

    static boolean drawSelected = false;

    static boolean drawUnselected = false;

    boolean getResult() {
        return drawLine && drawSelected && drawUnselected;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9784().getResult());
    }
}
