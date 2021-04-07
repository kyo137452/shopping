package cn.tedu.shopping.service;

import java.util.List;

import cn.tedu.shopping.entity.District;

/**
 * 處理城市資料的業務層接口
 *
 */
public interface IDistrictService {
	
	/**
	 * 根據父級代號全國所有縣市列表
	 * @param parent 父及代號,如果嘗試獲取全國所有縣市,則代號應該"86"
	 * @return 全國所有縣市列表
	 */
	List<District> getByParent(String parent);
	


	/**
	 * 根據父級代號全國所有縣市列表
	 * @param code 父及代號,如果嘗試獲取全國所有縣市,則代號應該"86"
	 * @return 全國所有縣市列表
	 */
	District getByCode(String code);
	
	
	
	
	
	
	
	
	
	
	
}























