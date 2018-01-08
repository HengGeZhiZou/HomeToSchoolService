package priv.lyh.hts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import priv.lyh.hts.entity.ReturnInfo;
import priv.lyh.hts.entity.Students;
import priv.lyh.hts.exception.ServiceException;
import priv.lyh.hts.service.AdminService;
import priv.lyh.hts.service.NewsService;

import javax.annotation.Resource;

import static priv.lyh.hts.util.ResultCode.REQUEST_SUCCESS;
import static priv.lyh.hts.util.ResultCode.REQUEST_SUCCESS_MSG;
import static priv.lyh.hts.util.ResultCode.SEND_FAIL;

@Controller
@RequestMapping("/hts/admin/*")
public class AdminController {

    @Resource(name = "newsServiceImpl")
    private NewsService newsService;

    @Resource(name = "adminServiceImpl")
    private AdminService adminService;

    private ReturnInfo returnInfo=new ReturnInfo();

//   抓取新闻
    @RequestMapping(value = "catchNews",method = RequestMethod.GET)
    public
    @ResponseBody
    ReturnInfo catchNews() throws ServiceException {
        newsService.catchNews();
        returnInfo.setInfo(REQUEST_SUCCESS,REQUEST_SUCCESS_MSG);
        return returnInfo ;
    }
//录入新生信息
    @RequestMapping(value = "importStu",method = RequestMethod.POST)
    public
    @ResponseBody
    ReturnInfo importStu(@RequestParam(value = "filename")MultipartFile file) throws ServiceException {

        try{
            String filename=file.getOriginalFilename();
            boolean b=adminService.importStudents(filename,file);
            if (b){
                returnInfo.setInfo(REQUEST_SUCCESS,"录入成功");
                return returnInfo;
            }
            else {
                returnInfo.setInfo(SEND_FAIL,"表格中属性不为空");
                return returnInfo;
            }
        }catch (Exception e){
            throw new ServiceException("请检查以下错误 1.存在部分学生已经录入  2.表中属性不能为空");
        }
    }


//    手动录入少量学生
    @RequestMapping(value = "addStu",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody ReturnInfo addStu(@RequestBody Students students) throws ServiceException {
        adminService.addStu(students);
        returnInfo.setInfo(REQUEST_SUCCESS,"录入成功");
        return  returnInfo;
    }
}
