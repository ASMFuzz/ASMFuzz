public class MyJVMTest_13338 {

    static Integer i = -247955882;

    static T t = null;

    int identity(Integer i) {
        switch(i) {
            case 0:
                return 0;
            default:
                return i;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13338().identity(i));
    }
}
