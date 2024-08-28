import java.io.*;

public class MyJVMTest_6423 {

    static int numWriteObject = 0;

    static int numReadObject = 0;

    static String value = "/|fn`*&K@f";

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
        new MyJVMTest_6423().validateObject();
    }
}
