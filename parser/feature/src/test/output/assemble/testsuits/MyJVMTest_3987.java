public class MyJVMTest_3987 {

    static Integer i = 0;

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
        System.out.println(new MyJVMTest_3987().identity(i));
    }
}
