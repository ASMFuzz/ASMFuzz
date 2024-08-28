import java.io.*;
import java.text.*;
import java.util.Locale;

public class MyJVMTest_8117 {

    String getSourceString() {
        return "CollationKeyTestImpl";
    }

    byte[] toByteArray() {
        String foo = "Hello";
        return foo.getBytes();
    }

    void testSubclassMethods() {
        CollationKeyTestImpl clt1 = new CollationKeyTestImpl("testSubclassMethods-1");
        CollationKeyTestImpl clt2 = new CollationKeyTestImpl("testSubclassMethods-2");
        if (!clt1.equals(clt2)) {
            throw new RuntimeException("Failed: equals(CollationKeySubClass)");
        }
        if (clt1.compareTo(clt2) != 0) {
            throw new RuntimeException("Failed: compareTo(CollationKeySubClass)");
        }
        if (!clt1.getSourceString().equals("CollationKeyTestImpl")) {
            throw new RuntimeException("Failed: CollationKey subclass overriding getSourceString()");
        }
        String str2 = new String(clt2.toByteArray());
        if (!clt2.equals("Hello")) {
            throw new RuntimeException("Failed: CollationKey subclass toByteArray()");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8117().testSubclassMethods();
    }
}
