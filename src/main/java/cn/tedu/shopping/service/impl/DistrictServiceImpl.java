package cn.tedu.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.tedu.shopping.entity.District;
import cn.tedu.shopping.mapper.DistrictMapper;
import cn.tedu.shopping.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {
	
	@Autowired
	private DistrictMapper districtMapper;

	@Override
	public List<District> getByParent(String parent) {
		return findByParent(parent);
	}
	
	@Override
	public District getByCode(String code) {
		return findByCode(code);
	}


	/**
	 * 根據父級代號全國所有縣市列表
	 * @param parent 父及代號,如果嘗試獲取全國所有縣市,則代號應該"86"
	 * @return 全國所有縣市列表
	 */
	private List<District> findByParent(String parent) {
		return districtMapper.findByParent(parent);
	}

	
	private District findByCode(String code) {
		return districtMapper.findByCode(code);
	}

	
}























