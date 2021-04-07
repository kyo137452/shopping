package cn.tedu.shopping.service.ex;

/**
 * 刪除資料異常
 */
public class DeleteException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super();

	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);

	}

	public DeleteException(String message) {
		super(message);

	}

	public DeleteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
