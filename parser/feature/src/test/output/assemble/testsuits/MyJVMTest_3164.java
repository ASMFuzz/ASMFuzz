import java.io.File;

public class MyJVMTest_3164 {

    static String extra = "8Z)4xSnQ/c";

    static String contents = "-BLvnx\"6JK";

    String basicUpdate(String extra) {
        this.contents = this.contents + extra;
        return extra;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3164().basicUpdate(extra);
    }
}
