public class MyJVMTest_17677 {

    Object returnObject() {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17677().returnObject());
    }
}
