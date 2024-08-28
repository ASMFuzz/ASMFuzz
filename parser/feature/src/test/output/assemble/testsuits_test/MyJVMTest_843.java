public class MyJVMTest_843 {

    static int index = 8;

    static String value = ")|cFy^jpF ";

    int getClassIndex() throws IllegalStateException {
        if (value != null) {
            throw new IllegalStateException();
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_843().getClassIndex());
    }
}
