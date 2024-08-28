public class MyJVMTest_15098 {

    int fopt() {
        int local;
        local = -2;
        return local;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15098().fopt());
    }
}
