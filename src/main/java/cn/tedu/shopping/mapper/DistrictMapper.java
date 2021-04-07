package cn.tedu.shopping.mapper;

import java.util.List;

import cn.tedu.shopping.entity.District;

/**
 * 處理城市資料的持久層接口
 *
 */
public interface DistrictMapper {
	
	/**
	 * 根據父級代號全國所有縣市列表
	 * @param parent 父及代號,如果嘗試獲取全國所有縣市,則代號應該"86"
	 * @return 全國所有縣市列表
	 */
	List<District> findByParent(String parent);
	
	/**
	 * 根據縣市代號查詢詳情
	 * @param code 縣市代號
	 * @return 匹配的城市的詳情,如果沒有則返回null
	 */
	District findByCode(String code);

	
	
}



















