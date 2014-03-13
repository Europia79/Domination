package co.battlecraft.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/*
 * @author VoidWhisperer
 * 
 * https://forums.bukkit.org/threads/dependency-download-enable.98955/
 * 
 */

public class Download {
    // static String uri = "http://dev.bukkit.org/media/files/614/520/Vault.jar";
    static String path;
    static String pluginActualName = "";
    static String pluginOutputTag = "[Downloading]";
    final static int size = 1024;
    public static void install(String fileUrl, String dest, String fileName)
            throws MalformedURLException, IOException
    {
        Bukkit.getLogger().info("installing debug library");

            path = dest + File.separator + fileName;
            File folder = new File(path).getParentFile();
            if (folder != null) {
                folder.mkdirs();
            }
 
 BufferedInputStream in = null;
 FileOutputStream fout = null;
 try {
 in = new BufferedInputStream(new URL(fileUrl).openStream());
 fout = new FileOutputStream(path);

byte data[] = new byte[1024];
 int count;
 while ((count = in.read(data, 0, 1024)) != -1) {
 fout.write(data, 0, count);
 }
 } finally {
 if (in != null)
 in.close();
 if (fout != null)
 fout.close();
 }        
            
      /*      
            URL url = new URL(fileUrl);
            URLConnection urlC = url.openConnection();
            InputStream is = urlC.getInputStream();
            byte[] buffer = new byte[size];
            int ByteRead = 0;
            OutputStream os = new BufferedOutputStream(new FileOutputStream(path));
            while((ByteRead = is.read(buffer)) != -1)
            {
            //    System.out.println(".");
                os.write(buffer,0,ByteRead);
            }
            os.flush();
            Bukkit.getLogger().info(pluginOutputTag + " Saved file as " + fileName + " to /" + dest);
        }catch(Exception e)
        {
            Bukkit.getLogger().severe(e.getMessage());
        } */

    }
}