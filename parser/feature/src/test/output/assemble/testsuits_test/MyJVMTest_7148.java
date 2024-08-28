import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_7148 {

    void clear() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7148().clear();
    }
}
