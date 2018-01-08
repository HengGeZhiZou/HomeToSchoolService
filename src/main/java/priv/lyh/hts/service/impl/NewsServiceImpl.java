package priv.lyh.hts.service.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import priv.lyh.hts.dao.NewsDao;
import priv.lyh.hts.entity.News;
import priv.lyh.hts.exception.ServiceException;
import priv.lyh.hts.service.NewsService;
import priv.lyh.hts.util.GetNewsByWebMagic;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

@Service
@Transactional
@Scope("prototype")
public class NewsServiceImpl implements NewsService {

    @Resource(name = "newsDaoImpl")
    private NewsDao newsDao;

    private static String url="http://www.cdnu.edu.cn";

    @Override
    public void catchNews() throws ServiceException {
        try {
            Spider.create(new GetNewsByWebMagic()).addUrl(url).thread(5).run();
        }catch (Exception e){
            throw new ServiceException("获取新闻失败，请检查网络是否畅通以及学校官网是否能够正常打开");
        }
    }

    @Override
    public void saveNews(News news) {

        newsDao.save(news);
    }
}
