public class MyJVMTest_17024 {

    static Object obj = 9;

    Object s_object_par_method(Object obj) {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17024().s_object_par_method(obj));
    }
}
