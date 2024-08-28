import java.beans.XMLDecoder;

public class MyJVMTest_15151 {

    static String message = "A[wZTXv oB";

    String getMessage() {
        if (this.message == null) {
            throw new Error("owner's method is not called");
        }
        return this.message;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15151().getMessage());
    }
}
