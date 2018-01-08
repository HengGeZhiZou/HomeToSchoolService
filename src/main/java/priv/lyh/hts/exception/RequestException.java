package priv.lyh.hts.exception;


public class RequestException extends SysException {
    public RequestException(){
    super("HTS:The request layer an exception occurs");
    }

    public RequestException(String msg){
        super(msg);
    }
}
