package cn.tedu.shopping.service.ex;

/**
 * 拒絕訪問,嘗試訪問他人的資料
 */
public class AccessDeniedException extends ServiceException {


	private static final long serialVersionUID = 1L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}


	
}
