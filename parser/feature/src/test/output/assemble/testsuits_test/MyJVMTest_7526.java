import java.io.*;

public class MyJVMTest_7526 {

    static CircularListTest next = null;

    static CircularListTest list = null;

    void setup() {
        list = new CircularListTest();
        list.next = list;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7526().setup();
    }
}
