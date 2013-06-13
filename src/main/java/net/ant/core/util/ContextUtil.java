package net.ant.core.util;


/**
 * 上下文工具
 *
 * @author lsr
 * @version 2013-4-2
 */
public class ContextUtil {
    /**
     * 获取上下文路径
     */
    public static String getContextPath() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String classPath = classLoader.getResource("").getPath();
        String contextPath = classPath.replace("WEB-INF/classes/", "");
        contextPath = contextPath.replace("%20", " ");
        contextPath=contextPath.replaceFirst("/", "");
        return contextPath;
    }
}
