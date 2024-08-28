public class MyJVMTest_17263 {

    static Class<?> clazz = null;

    static boolean anonymous = true;

    static boolean local = true;

    static boolean member = false;

    int test(Class<?> clazz, boolean anonymous, boolean local, boolean member) {
        if (clazz.isAnonymousClass() != anonymous) {
            System.err.println("Unexpected isAnonymousClass value for " + clazz.getName() + " expected: " + anonymous + " got: " + (!anonymous));
            return 1;
        }
        if (clazz.isLocalClass() != local) {
            System.err.println("Unexpected isLocalClass value for " + clazz.getName() + " expected: " + local + " got: " + (!local));
            return 1;
        }
        if (clazz.isMemberClass() != member) {
            System.err.println("Unexpected isMemberClass status for " + clazz.getName() + " expected: " + member + " got: " + (!member));
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17263().test(clazz, anonymous, local, member));
    }
}
