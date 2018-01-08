package priv.lyh.hts.service;


import org.springframework.web.multipart.MultipartFile;
import priv.lyh.hts.entity.Students;
import priv.lyh.hts.exception.ServiceException;

public interface AdminService {
    boolean importStudents(String name, MultipartFile file);  // 利用excel录入新生

    void addStu(Students students) throws ServiceException;  //录入少量学生
}
