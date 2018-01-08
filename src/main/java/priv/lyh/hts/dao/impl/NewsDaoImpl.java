package priv.lyh.hts.dao.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import priv.lyh.hts.dao.NewsDao;
import priv.lyh.hts.entity.News;

import java.util.List;

@Repository
@Scope("prototype")
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

    @Override
    public String getLastNews() {
        String hql="select max(newsId) from News";
        List<String> list= (List<String>) this.getHibernateTemplate().find(hql);
        if (list!=null) return list.get(0);
        return null;
    }
}
