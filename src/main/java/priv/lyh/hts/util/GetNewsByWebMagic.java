package priv.lyh.hts.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import priv.lyh.hts.dao.NewsDao;
import priv.lyh.hts.entity.News;
import priv.lyh.hts.service.NewsService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.List;



public class GetNewsByWebMagic implements PageProcessor {

    private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    NewsService newsService= (NewsService) ac.getBean("newsServiceImpl");
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private int count=1;
    private List<News> newsList;
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(http://www\\.cdnu\\.edu\\.cn/[\\w\\-]+/[\\w\\-]+/[\\w\\-]+\\.html)").all());
        page.putField("date", page.getHtml().xpath("//ul[@class='cuhksz-detail-author']/li/text()").toString());
        String date=page.getHtml().xpath("//ul[@class='cuhksz-detail-author']/li/text()").toString();
        page.putField("title", page.getHtml().xpath("//h1/text()").toString());
        String title=page.getHtml().xpath("//h1/text()").toString();
        page.putField("type",page.getHtml().xpath("//div[@class='cuhksz-banner  cuhksz-banner-padding']/text()"));
        String type=page.getHtml().xpath("//div[@class='cuhksz-banner  cuhksz-banner-padding']/text()").toString();
        page.putField("content",page.getHtml().xpath("//div[@class='field-item even']/tidyText()"));
        String content=page.getHtml().xpath("//div[@class='field-item even']/tidyText()").toString();
        if (title!=null&&content!=null){
            News news=new News();
            news.setNewsId(String.valueOf(count));
            news.setNewsTitle(title);
            news.setNewsContent(content);
            news.setNewsType(type);
            news.setNewsDate(date);
            count++;
            newsService.saveNews(news);
        }
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
         Spider.create(new GetNewsByWebMagic()).addUrl("http://www.cdnu.edu.cn").thread(5).run();
    }
}
