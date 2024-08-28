public class MyJVMTest_4750 {

    Object cl() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4750().cl());
    }
}
