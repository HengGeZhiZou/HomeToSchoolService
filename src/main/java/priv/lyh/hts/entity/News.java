package priv.lyh.hts.entity;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class News {

    private String newsId;
    private String newsTitle;
    private String newsDate;
    private String newsType;
    private String newsContent;

    @Id
    @Column(name = "news_id")
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_title")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_date")
    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    @Basic
    @Column(name = "news_type")
    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    @Basic
    @Column(name = "news_content")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (newsId != null ? !newsId.equals(news.newsId) : news.newsId != null) return false;
        if (newsTitle != null ? !newsTitle.equals(news.newsTitle) : news.newsTitle != null) return false;
        if (newsDate != null ? !newsDate.equals(news.newsDate) : news.newsDate != null) return false;
        if (newsType != null ? !newsType.equals(news.newsType) : news.newsType != null) return false;
        if (newsContent != null ? !newsContent.equals(news.newsContent) : news.newsContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId != null ? newsId.hashCode() : 0;
        result = 31 * result + (newsTitle != null ? newsTitle.hashCode() : 0);
        result = 31 * result + (newsDate != null ? newsDate.hashCode() : 0);
        result = 31 * result + (newsType != null ? newsType.hashCode() : 0);
        result = 31 * result + (newsContent != null ? newsContent.hashCode() : 0);
        return result;
    }

    public News(String newsId, String newsTitle, String newsDate, String newsType, String newsContent) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsType = newsType;
        this.newsContent = newsContent;
    }

    public News() {
    }
}
