public class MyJVMTest_3502 {

    static String loadedName = "[[7Zv0We}}";

    String printName(String loadedName) {
        System.out.println("Loaded Name: " + loadedName);
        byte[] theLoadedNameByteArray = loadedName.getBytes();
        System.out.print("Name Bytes: ");
        for (int i = 0; i < theLoadedNameByteArray.length; i++) System.out.print((Integer.toHexString((int) theLoadedNameByteArray[i]).toUpperCase()) + " ");
        System.out.println("");
        System.out.println("");
        return loadedName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3502().printName(loadedName);
    }
}
