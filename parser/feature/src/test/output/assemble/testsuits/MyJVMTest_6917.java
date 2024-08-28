import java.lang.Character.UnicodeBlock;

public class MyJVMTest_6917 {

    static boolean err = false;

    void test4830803_2() {
        boolean threwExpected = false;
        try {
            UnicodeBlock block = UnicodeBlock.forName("notdefined");
        } catch (IllegalArgumentException e) {
            threwExpected = true;
        }
        if (threwExpected == false) {
            System.err.println("Error: UnicodeBlock.forName(\"notdefined\") should throw IllegalArgumentException.");
            err = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6917().test4830803_2();
    }
}
