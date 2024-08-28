import java.io.*;

public class MyJVMTest_6496 {

    static int a = 8, b = 5;

    static int validates = 0;

    void validateObject() throws InvalidObjectException {
        if (validates > 0)
            throw new Error("Implementation error: Re-validating object " + this.toString());
        validates++;
        System.out.println("Validating " + this.toString());
        if (a > b) {
            throw new InvalidObjectException("Fields cannot be negative");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6496().validateObject();
    }
}
