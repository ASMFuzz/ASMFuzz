public class MyJVMTest_12614 {

    static Integer i = 0;

    Integer test() {
        return this.i++;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12614().test());
    }
}
