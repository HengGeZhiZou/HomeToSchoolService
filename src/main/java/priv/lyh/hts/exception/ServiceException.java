package priv.lyh.hts.exception;

public class ServiceException extends SysException {

    public ServiceException(){
        super("HTS:The service layer an exception occurs");
    }

    public ServiceException(String msg){
        super(msg);
    }
}
