import java.io.File;

public class MyJVMTest_10241 {

    static String contents = "h8^L[~Eqmx";

    Object initialSnapshot() throws Exception {
        this.contents = "";
        return (this);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10241().initialSnapshot());
    }
}
