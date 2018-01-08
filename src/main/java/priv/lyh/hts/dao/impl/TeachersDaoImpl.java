package priv.lyh.hts.dao.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import priv.lyh.hts.dao.TeachersDao;
import priv.lyh.hts.entity.Teachers;

@Repository
@Scope("prototype")
public class TeachersDaoImpl extends BaseDaoImpl<Teachers> implements TeachersDao {
}
