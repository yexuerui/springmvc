package com.springmvc.common;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import javax.xml.transform.Source;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName PictureUtil
 * @Description 图片处理类
 * @Author xueruiye
 * @Date 2019/5/13
 * @Version 1.0
 **/
public class PictureUtil {

    /**
     * 按照比例，进行宽高的大小缩放
     * 宽或者高超出设置时，缩小至设置长度，对应的宽或者高进行缩放
     */
    public static void sizeZoomByIs(InputStream is, File target, int width, int height, boolean isKeepAspectRatio) throws IOException {
        if (width == 0)
            width = 2560;
        if (height == 0)
            height = 1920;
        Thumbnails.of(is).size(2560, 1920).keepAspectRatio(isKeepAspectRatio).toFile(target);
    }

    /**
     * 按照比例，进行宽高的大小缩放
     *
     * @param source            源文件
     * @param target            目标地址
     * @param width             宽度
     * @param height            高度
     * @param isKeepAspectRatio 是否按照比例进行缩减
     */
    public static void sizeZoomBySource(String source, File target, int width, int height, boolean isKeepAspectRatio) throws IOException {
        if (width == 0)
            width = 2560;
        if (height == 0)
            height = 1920;
        Thumbnails.of(source).size(2560, 1920).keepAspectRatio(isKeepAspectRatio).toFile(target);
    }


    /**
     * 按照比例进行缩减
     *
     * @param url
     * @param target
     * @param scale
     * @throws IOException
     */
    public static void scaleZoomByUrl(URL url, String target, double scale) throws IOException {
        /**
         * scale(比例)
         */
        Thumbnails.of(url).scale(scale)
                .toFile(target);
    }

//    public static void rotateZoomBySource(String source, int width, int height, String target) {
//        Thumbnails.of(source)
//
//    }

    /**
     * 加文字水印
     */
    public static void textWatermark() throws IOException {
        String result = "src/main/resource/images/";
        BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        //文字图像的基本类
        Graphics2D g = bi.createGraphics();
        g.setColor(Color.LIGHT_GRAY);
        //设置大小
        g.drawRect(0, 0, 10, 10);
        char[] data = "liudTest".toCharArray();
        //设置文字
        g.drawChars(data, 0, data.length, 5, 32);
        // watermark 参数 1.位置 2.水印 3.透明度
        Thumbnails.of(result + "001.jpg").scale(1.0f).watermark(Positions.CENTER, bi, 1.0f).toFile(result + "image_warter_liud.jpg");
    }

    /**
     * @param srcPath       源图片
     * @param destPath      目标图片
     * @param watermarkPath 水印图片
     * @param opacity       透明度
     */
    public static void watermark(String srcPath, String destPath, String watermarkPath, float opacity) throws IOException {
        Thumbnails.of(srcPath).size(1280, 1024)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(watermarkPath)), opacity)
                .outputQuality(1.0f)
                .toFile(destPath);
    }


    /**
     * 公网图片保存到本地
     *
     * @param certURL
     * @param destFile
     * @param userId
     */
    public static void downLoadPicFromPublivoidcNetToLocal(String certURL, String destFile, String userId) {
        try {
            //获取url对象
            URL url = new URL(certURL);
            //返回一个URLConnection实例，表示与URL引用的远程对象的URL。
            // 例如，对于HTTP，将返回一个HttpURLConnection，对于JAR，将返回一个JarURLConnection。
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片信息
            InputStream is = conn.getInputStream();
            //将字节数组当做输出的目的地
            byte[] data = readInputStream(is);
            int size = data.length;
            //创建File对象保存资源
            File fileDir = new File(destFile + "/picture/");
            if (!fileDir.exists()) {
                fileDir.mkdirs();//创建目录(将整个路径均作为目录创建出来)
            }
            File file = new File(destFile + "/picture/" + userId + ".jpg");
            //创建输出流
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(data);
            outputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将输入流文件保存到临时文件系统（数组中。减少与磁盘的交互）中
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        //获取数据到临时文件程序
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        inputStream.close();
        //获取字节数组
        return os.toByteArray();
    }


    /**
     * 测试类
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        //  D:/veradm/springmvc/target/classes/   若是文件不存在，那么获取null
//        URL resource = PictureUtil.class.getClassLoader().getResource("images/001.jpg");

        //获取classpath目录下的资源
        String srcPath = PictureUtil.class.getClassLoader().getResource("images/001.jpg").getPath();
        String destResourcePath= PictureUtil.class.getClassLoader().getResource("").getPath()+"images/001_wartermark.png";
        URL watermarkResource = PictureUtil.class.getClassLoader().getResource("images/watermark_1.png");
        String watermarkResourcePath = watermarkResource.getPath();
        watermark(srcPath, destResourcePath, watermarkResourcePath, 0.8f);
    }
}
