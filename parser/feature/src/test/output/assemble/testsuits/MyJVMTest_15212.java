import static java.awt.GraphicsEnvironment.*;

public class MyJVMTest_15212 {

    static boolean done = false;

    static int wheelX = 9;

    static int wheelY = 0;

    static int mouseX = 3;

    static int mouseY = 1;

    void validate() {
        if (!done || wheelX != mouseX || wheelY != mouseY) {
            System.err.println("Expected X: " + mouseX);
            System.err.println("Expected Y: " + mouseY);
            System.err.println("Actual X: " + wheelX);
            System.err.println("Actual Y: " + wheelY);
            throw new RuntimeException("Test failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15212().validate();
    }
}
