import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_2019 {

    static T[] a = { Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, 0.4993903f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY };

    <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2019().toArray(a)));
    }
}
