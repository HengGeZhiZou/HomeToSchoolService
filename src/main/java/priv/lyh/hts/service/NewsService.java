package priv.lyh.hts.service;


import priv.lyh.hts.entity.News;
import priv.lyh.hts.exception.ServiceException;

public interface NewsService {

     void catchNews() throws ServiceException;  // ץȡ����

     void saveNews(News news);  //��������
}
