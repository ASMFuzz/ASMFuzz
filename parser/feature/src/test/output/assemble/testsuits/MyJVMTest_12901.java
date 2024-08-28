public class MyJVMTest_12901 {

    Integer barfoo() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12901().barfoo());
    }
}
