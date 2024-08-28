public class MyJVMTest_12038 {

    String getName() {
        return "noname";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12038().getName());
    }
}
