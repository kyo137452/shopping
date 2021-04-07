package cn.tedu.shopping.service.ex;

/**
 * 暱稱錯誤,請重新輸入
 */
public class NicknameNotFoundExceptoin extends ServiceException {

	private static final long serialVersionUID = 1L;

	public NicknameNotFoundExceptoin() {
		super();

	}

	public NicknameNotFoundExceptoin(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public NicknameNotFoundExceptoin(String message, Throwable cause) {
		super(message, cause);

	}

	public NicknameNotFoundExceptoin(String message) {
		super(message);

	}

	public NicknameNotFoundExceptoin(Throwable cause) {
		super(cause);

	}

}
