public class MyJVMTest_9021 {

    Object returnObject() {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9021().returnObject());
    }
}
