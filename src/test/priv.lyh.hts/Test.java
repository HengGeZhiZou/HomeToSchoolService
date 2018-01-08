package priv.lyh.hts;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import priv.lyh.hts.entity.News;
import priv.lyh.hts.exception.ServiceException;
import priv.lyh.hts.service.NewsService;
import priv.lyh.hts.util.GetNewsByWebMagic;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test {

    @Resource(name = "newsServiceImpl")
    public NewsService newsService;

    @org.junit.Test
    public void testSave(){
        News news=new News();
        news.setNewsId("124");
        news.setNewsTitle("欢迎各位领导莅临我校");
        news.setNewsDate("20190808");
        news.setNewsContent("牛逼");
        news.setNewsType("校内新闻");
        newsService.saveNews(news);
    }

    @org.junit.Test
    public void testGetNews(){
//        Spider.create(new GetNewsByWebMagic()).addUrl("http://www.cdnu.edu.cn").thread(5).run();
        try {
            newsService.catchNews();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
