import java.io.*;
import java.util.*;
import java.lang.annotation.*;

public class MyJVMTest_12231 {

    void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12231().remove();
    }
}
