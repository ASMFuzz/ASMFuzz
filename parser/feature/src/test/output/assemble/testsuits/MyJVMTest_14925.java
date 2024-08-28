import java.util.function.*;

public class MyJVMTest_14925 {

    void test() {
        MyComparator.mycomparing1((String e) -> e.concat(""));
        MyComparator.mycomparing2((String e) -> e.concat(""));
        MyComparator.mycomparing3((String e) -> e.concat(""));
        MyComparator.mycomparing4((String e) -> e.concat(""));
        MyComparator.mycomparing1((e) -> e.toString());
        MyComparator.mycomparing2((e) -> e.toString());
        MyComparator.mycomparing3((e) -> e.toString());
        MyComparator.mycomparing4((e) -> e.toString());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14925().test();
    }
}
