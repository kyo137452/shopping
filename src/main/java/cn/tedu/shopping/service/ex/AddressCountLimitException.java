package cn.tedu.shopping.service.ex;

/**
 * 收件地址數量達到上限
 */
public class AddressCountLimitException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public AddressCountLimitException() {
		super();
		
	}

	public AddressCountLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AddressCountLimitException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressCountLimitException(String message) {
		super(message);
		
	}

	public AddressCountLimitException(Throwable cause) {
		super(cause);
		
	}
	

}










