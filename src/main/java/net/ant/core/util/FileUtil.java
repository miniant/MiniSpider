package net.ant.core.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * 文件工具类
 * 
 */
public class FileUtil {

    public static String getFileType(File file) {
        return getFileSuffix(file.getName());
    }

    /**
     * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
     * 
     * @param fileName
     *            文件名
     * @return 文件名中的类型部分
     * @since 0.5
     */
    public static String getFileSuffix(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point + 1, length);
        }
    }

    /**
     * 上传图片保存到本地
     * 
     * @param httpUrl
     * @param filePath
     * @return 图片的宽(width)、高(height)、大小(size)
     * @throws Exception
     */
    public static Map<String, Integer> uploadImg(String httpUrl, String filePath) throws Exception {
        File f = new File(filePath);
        URL url = new URL(httpUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(60000);
        con.setReadTimeout(60000);
        con.connect();
        //url.openStream()
        BufferedInputStream in = new BufferedInputStream(con.getInputStream());
        FileOutputStream file = new FileOutputStream(f);
        int t;
        while ((t = in.read()) != -1) {
            file.write(t);
        }
        
        BufferedImage img = ImageIO.read(f);
        Map<String, Integer> picInfo = new HashMap<String, Integer>();
        picInfo.put("width", img.getWidth());
        picInfo.put("height", img.getHeight());
        picInfo.put("size", con.getContentLength());
        
        file.close();
        in.close();
        con.disconnect();
        
        return picInfo;
    }

}