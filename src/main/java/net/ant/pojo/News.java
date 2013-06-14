package net.ant.app.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ant.core.util.DateUtil;
import net.ant.core.util.IdGenerator;

/**
 * 新闻实体
 * 
 * @author lsr
 * @version 2011-6-2
 */

public class News implements Serializable {

    private static final long serialVersionUID = -2774874441328332682L;
    /**
     * 主键
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 内容
     */
    private String content;

    /**
     * 图片信息存储的url,用#分割
     */
    private String images;
    
    private List<Picture> pictures = new ArrayList<Picture>();

    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 数据来源url
     */
    private String originUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    private Boolean isTop;

    /**
     * 栏目
     */
    private String type;
    /**
     * 网站
     */
    private String site;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public static News createDefaultInstance() {
        News news = new News();
        news.setId(IdGenerator.generateId());
        news.setCreateTime(DateUtil.getNow());
        news.setIsTop(false);
        return news;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }


}
