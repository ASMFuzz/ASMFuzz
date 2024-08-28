import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.spi.*;
import java.util.*;
import java.util.zip.*;
import static java.nio.file.StandardCopyOption.*;

public class MyJVMTest_3580 {

    FileSystemProvider getZipFSProvider() {
        for (FileSystemProvider provider : FileSystemProvider.installedProviders()) {
            if ("jar".equalsIgnoreCase(provider.getScheme()))
                return provider;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3580().getZipFSProvider());
    }
}
