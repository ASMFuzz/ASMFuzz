public class MyJVMTest_9851 {

    static int index = 0;

    static String value = "Oh#yYF2S}J";

    int getNameIndex() throws IllegalStateException {
        if (value != null) {
            throw new IllegalStateException();
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9851().getNameIndex());
    }
}
