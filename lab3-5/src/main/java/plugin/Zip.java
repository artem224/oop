package plugin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip implements IPlugin {

    @Override
    public void action(String extension) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("zipstream.zip"));
             FileInputStream fis = new FileInputStream(IPlugin.srcName(extension))) {

            ZipEntry zipEntry = new ZipEntry(IPlugin.srcName(extension));
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            zos.closeEntry();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
