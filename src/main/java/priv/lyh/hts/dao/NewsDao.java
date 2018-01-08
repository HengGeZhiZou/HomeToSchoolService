package priv.lyh.hts.dao;


import priv.lyh.hts.entity.News;

public interface NewsDao extends BaseDao<News> {

    String getLastNews();
}
