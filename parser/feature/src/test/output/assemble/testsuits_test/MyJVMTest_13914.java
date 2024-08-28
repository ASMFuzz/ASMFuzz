import java.io.*;

public class MyJVMTest_13914 {

    static int len = 266595281;

    static int chunk = 9;

    static int count = 0;

    int available() {
        int remaining = len - count;
        return (remaining > chunk) ? chunk : remaining;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13914().available());
    }
}
