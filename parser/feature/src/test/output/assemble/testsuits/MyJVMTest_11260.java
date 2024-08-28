import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_11260 {

    static T[] a = { 6089139232953562566L, 9223372036854775807L, 0, 2188225672350048272L, -7032681065606234331L, 0, -9223372036854775808L, -4391221810729387107L, 0, 0 };

    <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11260().toArray(a)));
    }
}
