public class MyJVMTest_13102 {

    void myMethod2() {
        System.out.println("Target 0: myMethod2");
    }

    void myMethod1() {
        System.out.println("Target 0: myMethod1: Calling myMethod2()");
        myMethod2();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13102().myMethod1();
    }
}
