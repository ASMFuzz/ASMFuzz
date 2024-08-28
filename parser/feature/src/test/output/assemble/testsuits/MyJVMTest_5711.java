import java.beans.XMLDecoder;

public class MyJVMTest_5711 {

    static String message = "/`_hpAM&&,";

    String getMessage() {
        if (this.message == null) {
            throw new Error("owner's method is not called");
        }
        return this.message;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5711().getMessage());
    }
}
