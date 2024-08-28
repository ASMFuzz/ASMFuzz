public class MyJVMTest_7487 {

    static Object obj = 0;

    Object s_object_par_method(Object obj) {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7487().s_object_par_method(obj));
    }
}
