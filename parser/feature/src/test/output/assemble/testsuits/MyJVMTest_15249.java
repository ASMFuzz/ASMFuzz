import java.io.*;
import java.text.*;
import java.util.Locale;

public class MyJVMTest_15249 {

    static CollationKey[] keys = { null, null, null, null, null, null, null, null, null, null };

    int compareTo(CollationKey target) {
        return 0;
    }

    CollationKey[] InsertionSort(CollationKey[] keys) {
        int f, i;
        CollationKey tmp;
        for (f = 1; f < keys.length; f++) {
            if (keys[f].compareTo(keys[f - 1]) > 0) {
                continue;
            }
            tmp = keys[f];
            i = f - 1;
            while ((i >= 0) && (keys[i].compareTo(tmp) > 0)) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = tmp;
        }
        return keys;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15249().InsertionSort(keys);
    }
}
