package priv.lyh.hts.exception;


public class SysException extends Exception {
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    //下面几个全是不同的构造方法
    public SysException() {
        super();
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
        errorMsg=message;
    }

    public SysException(String message) {
        super(message);
        errorMsg=message;
    }

    public SysException(Throwable cause) {
        super(cause);
    }
}
