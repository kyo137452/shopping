package cn.tedu.shopping.service.ex;

/**
 * 電話號碼錯誤,請重新輸入
 */
public class PhoneNotFoundException extends ServiceException {

	
	private static final long serialVersionUID = 1L;

	public PhoneNotFoundException() {
		super();	
	}

	public PhoneNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PhoneNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PhoneNotFoundException(String message) {
		super(message);
		
	}

	public PhoneNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
