package priv.lyh.hts.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.lyh.hts.entity.ReturnInfo;
import priv.lyh.hts.exception.ServiceException;
import priv.lyh.hts.util.ResultCode;


@ControllerAdvice
public class GlobalExceptionHandler {
    private ReturnInfo returnInfo = new ReturnInfo();

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ReturnInfo ServiceException(Exception ex) {
        returnInfo.setInfo(ResultCode.SEND_FAIL, ex.getMessage());
        return returnInfo;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ReturnInfo superException(Exception ex){
        returnInfo.setInfo(ResultCode.SEND_FAIL,ex.getMessage());
        return returnInfo;
    }
}
