import java.io.*;

public class MyJVMTest_785 {

    static int len = 5;

    static int chunk = 0;

    char firstChar() {
        return 'a';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_785().firstChar());
    }
}
