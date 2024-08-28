import java.util.*;

public class MyJVMTest_3602 {

    void assertion1() {
        Test2.<A, B>check1(new A(), new B());
        Test1.<A, B>check1(new A(), new B());
        System.out.println("assertion1 passed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3602().assertion1();
    }
}
