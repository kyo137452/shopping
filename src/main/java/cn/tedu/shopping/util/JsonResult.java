package cn.tedu.shopping.util;

/**
 * 向客戶端響應操作結果的類型
 * 
 * @param <T> 向客戶端響應資料的類型
 */
public class JsonResult<T> {

	private Integer state;
	private String message;
	private T data;
	
	public JsonResult() {
		super();
	}

	public JsonResult(Integer state) {
		super();
		this.state = state;
	}

	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
