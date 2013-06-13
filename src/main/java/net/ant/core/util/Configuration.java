package net.ant.core.util;

import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 系统配置信息访问类
 */
public class Configuration {

    private static Log logger = LogFactory.getLog(Configuration.class);
    private Properties properties = new Properties();

    private static final Configuration config = new Configuration();
    private static final String DEFAULT_CONFIG_FILE = "config.properties";

    private Configuration() {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            properties.load(loader.getResourceAsStream(DEFAULT_CONFIG_FILE));
        } catch (Exception ex) {
            logger.error("Can't read the properties file. " + ex.getMessage());
        }
    }

    /**
     * 使用单例模式，返回配置类实例.
     * 
     * @return Configuration
     */
    public static Configuration getInstance() {
        return config;
    }

    /**
     * 获取指定Key的配置项的值.
     * 
     * @param key
     *            配置项键值.
     * @return 配置项的值
     */
    public String getValue(String key) {
        return properties.getProperty(key);
    }
    

}
