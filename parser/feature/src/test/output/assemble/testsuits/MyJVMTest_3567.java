public class MyJVMTest_3567 {

    Integer barfoo() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3567().barfoo());
    }
}
