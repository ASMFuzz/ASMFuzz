public class MyJVMTest_679 {

    static int index = 1;

    static String value = "_.{,Yk*qdm";

    int getNameIndex() throws IllegalStateException {
        if (value != null) {
            throw new IllegalStateException();
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_679().getNameIndex());
    }
}
