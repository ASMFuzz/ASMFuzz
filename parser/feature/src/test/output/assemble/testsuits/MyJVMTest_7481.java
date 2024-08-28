import java.util.*;

public class MyJVMTest_7481 {

    void assertion3() {
        Test2<A, B> tRef = new Test2<A, B>();
        tRef.<A, B>check3(new A(), new B());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7481().assertion3();
    }
}
