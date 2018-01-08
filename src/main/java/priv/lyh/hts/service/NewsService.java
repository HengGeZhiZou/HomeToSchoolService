package priv.lyh.hts.service;


import priv.lyh.hts.entity.News;
import priv.lyh.hts.exception.ServiceException;

public interface NewsService {

     void catchNews() throws ServiceException;  // 抓取新闻

     void saveNews(News news);  //保存新闻
}
