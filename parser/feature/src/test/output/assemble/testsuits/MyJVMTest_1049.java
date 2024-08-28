import java.io.File;

public class MyJVMTest_1049 {

    static String contents = "HwUW)<c6XN";

    Object initialSnapshot() throws Exception {
        this.contents = "";
        return (this);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1049().initialSnapshot());
    }
}
