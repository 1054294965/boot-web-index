package com.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、STORE_LOCATION 是图片存储路径，这个根据需要自定义
 * 2、抓取图片的需求不同，规则自定义下
 * 3、多网页抓取，用个for循环即可。
 */

public class DownloadImageUtils {
    private static Logger logger = LoggerFactory.getLogger(DownloadImageUtils.class);
    public static String STORE_LOCATION="F:\\pic\\";
    public static List<Image> images =new ArrayList<Image>();

    public static void main(String[] args) {
        int base=210000;
        for (int i=0;i<10000;i++){
//            http://www.fanup.info/229443.html
            int pageNo=base+i;
            String netUrl = "http://www.fanup.info/"+pageNo+".html"; //要爬的网页
            new DownloadImageUtils().start(netUrl);
        }

    }

    public void start(String pageUrl){
        List<Image> images = parsePage(pageUrl);
        downloadImage(images);

    }

    public List<Image> parsePage(String pageUrl){
        List<Image> images =new ArrayList<Image>();
        Connection connect = Jsoup.connect(pageUrl);
        Document document = null;
        try {
            document = connect.get();
            /* 自定义规则 */
            Elements elements = document.getElementsByTag("img"); // 找到所有img标签
                for (Element element : elements) {
                    String alt = element.attr("alt");
                    String src = element.attr("src");
                    Image image =  new Image();
                    if(!StringUtils.isEmpty(alt) && src.contains("imgs") && !src.contains("imgs2")){
                        System.out.println(element.html());
                        System.out.println(element.attr("src"));
                        image.setAlt(alt.replace("-FHD",""));
                        image.setSrc(src);
                        images.add(image);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }


    //下载该图片！
    public void downloadImage(List<Image> images){
        for (Image image:images) {
            InputStream in = null;
            BufferedOutputStream os = null;
            try {
                URL url = new URL(image.getSrc());
                File file = new File(STORE_LOCATION + image.getAlt() + ".jpg");
                logger.info("filename：{}",file.getAbsoluteFile());
                if(file.exists()){ //
                    return;
                }
                URLConnection conn = url.openConnection();
                in = conn.getInputStream();
                os = new BufferedOutputStream(new FileOutputStream(file.getAbsoluteFile()));
                byte[] buff = new byte[1024];
                int num = 0;
                while((num = in.read(buff))!= -1)
                {
                    os.write(buff, 0, num);
                    os.flush();
                }
            } catch (MalformedURLException e) {
                logger.error("获取图片url异常");
                e.printStackTrace();
            } catch (IOException e) {
                logger.error("下载图片url连接异常");
                e.printStackTrace();
            }
            finally{
                if( in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        logger.error("读入流关闭异常");
                    }
                }
                if( os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        logger.error("输出流关闭异常");
                    }
                }
            }
        }
    }

    static class Image {
        private String alt;
        private String src;
        public String getAlt() {
            return alt;
        }
        public void setAlt(String alt) {
            this.alt = alt;
        }
        public String getSrc() {
            return src;
        }
        public void setSrc(String src) {
            this.src = src;
        }
    }
}
