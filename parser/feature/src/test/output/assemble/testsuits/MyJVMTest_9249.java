public class MyJVMTest_9249 {

    T m() {
        return t;
    }

    static T t = null;

    T test() {
        class Local {

            T t;
        }
        ;
        class Local2 {

            T m() {
                return t;
            }
        }
        ;
        T t3 = new Local().t;
        return new Local2().m();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9249().m());
    }
}
