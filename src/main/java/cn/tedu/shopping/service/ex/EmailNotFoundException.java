package cn.tedu.shopping.service.ex;

/**
 * 電子信箱錯誤,請重新輸入
 */
public class EmailNotFoundException extends ServiceException {

	
	private static final long serialVersionUID = 1L;

	public EmailNotFoundException() {
		super();
		
	}

	public EmailNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public EmailNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EmailNotFoundException(String message) {
		super(message);
		
	}

	public EmailNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	

}
