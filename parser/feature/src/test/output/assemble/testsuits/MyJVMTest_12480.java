import java.io.File;

public class MyJVMTest_12480 {

    static String extra = ")xW0@z<YSf";

    static String contents = "&l2b_2oW*>";

    String basicUpdate(String extra) {
        this.contents = this.contents + extra;
        return extra;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12480().basicUpdate(extra);
    }
}
