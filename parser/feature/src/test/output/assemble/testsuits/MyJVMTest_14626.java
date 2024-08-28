public class MyJVMTest_14626 {

    static D d = null;

    void test() {
        class C {

            class D {
            }
        }
        class L extends C {
        }
        class X extends C {

            D d;
        }
        class Y extends L {

            D d;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14626().test();
    }
}
