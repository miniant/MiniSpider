package net.ant.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 说明：采集器工具类
 * 
 * @author lsr
 * @version Jun 2, 2011
 */
public class CollectorUtil {
    private static Log log = LogFactory.getLog(CollectorUtil.class);

    /**
     * 获取IMG的src地址
     * 
     * @param srcStr
     *            src的字符串
     * @return
     */
    public static String getSrcPathOfImg(String srcStr) {
        String pattern = "src=\"(.*?)\"";
        return getMatchedString(srcStr, pattern);
    }

    public static String getMatchedString(String originStr, String matchStr) {
        // String pattern = "\\" + matchStr + "\\";
        Pattern sp = Pattern.compile(matchStr);
        Matcher matcher = sp.matcher(originStr);
        String src = "";
        while (matcher.find()) {
            src = matcher.group();
            break;
        }
        return src;
    }

    public static String getDateFromStr(String orgStr, String matchStr) {
        Pattern sp = Pattern.compile(matchStr);
        Matcher matcher = sp.matcher(orgStr);
        String src = "";
        while (matcher.find()) {

            src = matcher.group();
            break;
        }

        return src;
    }

    /**
     * 根据url获取文档对象
     * 
     * @param url
     * @return
     */
    public static Document getDocument(String url) {
        Document document = null;
        // 读取HTML
        try {
            Connection conn = Jsoup.connect(url);
            document = conn.get();
        } catch (Exception e) {
            log.info("获取doc异常(" + url + "):" + e.getMessage());
            return null;
        }
        return document;
    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     * 
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNotEmpty(String input) {
        return !isEmpty(input);
    }
}
