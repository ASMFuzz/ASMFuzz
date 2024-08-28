import static java.awt.GraphicsEnvironment.*;

public class MyJVMTest_5769 {

    static boolean done = false;

    static int wheelX = 0;

    static int wheelY = -406379764;

    static int mouseX = 6;

    static int mouseY = 3;

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
        new MyJVMTest_5769().validate();
    }
}
