package cn.tedu.shopping.service.ex;

/**
  * 收件地址資料不存在
 *
 */
public class AddressNotFoundException extends ServiceException {

	
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		super();
		
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddressNotFoundException(String message) {
		super(message);
		
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	

}
