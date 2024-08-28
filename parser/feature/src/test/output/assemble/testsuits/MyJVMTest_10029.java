public class MyJVMTest_10029 {

    Class<?> getBeanType() {
        return Bean.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10029().getBeanType());
    }
}
