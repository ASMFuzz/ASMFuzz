import java.io.*;

public class MyJVMTest_15908 {

    static int numWriteObject = 0;

    static int numReadObject = 0;

    static String value = "SC+jp[@UFz";

    static int numReadResolve = 0;

    static int numWriteReplace = 0;

    void validateObject() throws InvalidObjectException {
        if (numWriteObject != 4) {
            throw new Error("Expected 4 calls to writeObject, only " + numWriteObject + " made");
        }
        if (numReadObject != 4) {
            throw new Error("Expected 4 calls to readObject, only " + numReadObject + " made");
        }
        if (numWriteReplace != 4) {
            throw new Error("Expected 4 calls to writeReplace, only " + numWriteReplace + " made");
        }
        if (numReadResolve != 4) {
            throw new Error("Expected 4 calls to readResolve, only " + numReadResolve + " made");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15908().validateObject();
    }
}
