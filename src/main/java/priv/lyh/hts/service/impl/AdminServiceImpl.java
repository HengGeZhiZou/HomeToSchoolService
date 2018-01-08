package priv.lyh.hts.service.impl;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import priv.lyh.hts.dao.StudentsDao;
import priv.lyh.hts.entity.Students;
import priv.lyh.hts.exception.ServiceException;
import priv.lyh.hts.service.AdminService;
import priv.lyh.hts.util.ReadExcel;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@Scope("prototype")
public class AdminServiceImpl implements AdminService {

    @Resource(name = "studentsDaoImpl")
    private StudentsDao studentsDao;

    @Override
    public boolean importStudents(String name, MultipartFile file) {

            boolean b=false;
            ReadExcel readExcel=new ReadExcel();
            List<Students> studentsList=readExcel.getExcelInfo(name,file);
            if (studentsList!=null){
                b=true;
            }
            for (Students students:studentsList){
                studentsDao.save(students);
            }
            return b;


    }

    @Override
    public void addStu(Students students) throws ServiceException {
        try{
            studentsDao.save(students);
        }
        catch (Exception e){
            throw new ServiceException("学号和表中数据已经重复");
        }



    }
}
