import java.awt.*;

public class MyJVMTest_16292 {

    static Frame currentFrame = null;

    int getNextLocationX() {
        return currentFrame.getX() + currentFrame.getWidth();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16292().getNextLocationX());
    }
}
