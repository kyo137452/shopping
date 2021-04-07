package cn.tedu.shopping.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.shopping.entity.Address;
import cn.tedu.shopping.mapper.AddressMapper;
import cn.tedu.shopping.service.IAddressService;
import cn.tedu.shopping.service.IDistrictService;
import cn.tedu.shopping.service.ex.AccessDeniedException;
import cn.tedu.shopping.service.ex.AddressCountLimitException;
import cn.tedu.shopping.service.ex.AddressNotFoundException;
import cn.tedu.shopping.service.ex.DeleteException;
import cn.tedu.shopping.service.ex.InsertException;
import cn.tedu.shopping.service.ex.UpdateException;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private IDistrictService districtService;

	@Override
	public void addnew(Address address, Integer uid, String username)
			throws AddressCountLimitException, InsertException {
		// 根據參數uid查詢當前用戶的收貨地址數量
		Integer count = countByUid(uid);
		// 判斷收貨地址數量是否達到上限ADDRESS_MAX_COUNT
		if (count >= ADDRESS_MAX_COUNT) {
			// 是：抛出：AddressCountLimitException
			throw new AddressCountLimitException(
				"增加收件地址失敗！當前收件地址數量已經達到上限！最多允許創造" + ADDRESS_MAX_COUNT + "條，已經創建" + count + "條！");
		}

		// 補全資料：uid
		address.setUid(uid);

		// 補全資料：province_name, city_name, area_name	
		// 判斷當前用戶的收貨地址數量是否為0，並決定is_default的值
		Integer isDefault = count == 0 ? 1 : 0;
		// 補全資料：is_default
		address.setIsDefault(isDefault);

		// 創建當前時間對象
		Date now = new Date();
		// 補全資料：4個日誌
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);

		// 插入收件地址資料
		insert(address);
	}

	@Override
	public List<Address> getByUid(Integer uid) {
		return findByUid(uid);
	}
	
	@Override
	@Transactional
	public void setDefault(Integer aid, Integer uid, String username)
			throws AddressNotFoundException, AccessDeniedException, UpdateException {
		// 根據aid查詢收件地址資料
		Address result = findByAid(aid);
	    // 判斷結果是否為null
		if (result == null) {
			// 是：抛出AddressNotFoundException
			throw new AddressNotFoundException(
				"設定預設地址失敗！嘗試操作的資料不存在！");
		}

	    // 判斷結果中的uid與參數uid是否不一致
		if (result.getUid() != uid) {
			// 是：抛出AccessDeniedException
			throw new AccessDeniedException(
				"設定預設收件地址失敗！不允許訪問他人的資料！");
		}

	    // 將該用戶全部收貨地址設置為非默認
		updateNonDefault(uid);

	    // 將指定的收貨地址設置為默認
		updateDefault(aid, username, new Date());
	}
	
	@Override
	@Transactional
	public void delete(Integer aid, Integer uid, String username)
			throws AddressNotFoundException, AccessDeniedException, DeleteException, UpdateException {
		// 根據aid查詢收件地址資料
		Address result = findByAid(aid);
	    // 判斷結果是否為null
		if (result == null) {
			// 是：抛出AddressNotFoundException
			throw new AddressNotFoundException(
				"刪除收件地址失敗！嘗試操作的資料不存在！");
		}

	    // 判斷結果中的uid與參數uid是否不一致
		if (result.getUid() != uid) {
			// 是：抛出AccessDeniedException
			throw new AccessDeniedException(
				"刪除收件地址失敗！不允許訪問他人的資料！");
		}

	    // 執行刪除
		deleteByAid(aid);

	    // 判斷當前的查詢結果中的isDefault是否為0
		if (result.getIsDefault() == 0) {
			// return;
			return;
		}

	    // 統計當前用戶的收件地址數量：countByUid()
		Integer count = countByUid(uid);
	    // 判斷剩下收件地址數量是否為0
		if (count == 0) {
			// return;
			return;
		}

	    // 查詢當前用戶最近修改的收貨地址
		Address lastModifiedAddress = findLastModified(uid);
	    // 將最近修改的收貨地址設置為默認
		updateDefault(lastModifiedAddress.getAid(), username, new Date());
	}
	
	/**
	 * 插入收貨地址數據
	 * @param address 收貨地址數據
	 * @throws InsertException 插入數據異常
	 */
	private void insert(Address address) throws InsertException {
		Integer rows = addressMapper.insert(address);
		if (rows != 1) {
			throw new InsertException(
				"增加收貨地址失敗！插入數據時出現未知錯誤！");
		}
	}
	
	/**
	 * 根据收货地址id删除数据
	 * @param aid 收货地址id
	 * @throws DeleteException 删除数据异常
	 */
	private void deleteByAid(Integer aid) throws DeleteException {
		Integer rows = addressMapper.deleteByAid(aid);
		if (rows != 1) {
			throw new DeleteException(
				"删除收货地址失败！删除时出现未知错误！");
		}
	}

	/**
	 * 將某用戶的所有收貨地址設置為非預設
	 * @param uid 用户的id
	 * @throws UpdateException 更新數據異常
	 */
	private void updateNonDefault(Integer uid) throws UpdateException {
		Integer rows = addressMapper.updateNonDefault(uid);
		if (rows == 0) {
			throw new UpdateException(
				"設置默認收貨地址失敗！更新時出現未知錯誤！");
		}
	}

	/**
	 * 將指定的收貨地址設置為預設
	 * @param aid 收件地址的資料id
	 * @param modifiedUser 修改執行人
	 * @param modifiedTime 修改時間
	 * @throws UpdateException 更新數據異常
	 */
	private void updateDefault(Integer aid, 
	    String modifiedUser, Date modifiedTime) 
			throws UpdateException {
		Integer rows = addressMapper.updateDefault(aid, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException(
				"設定預設收件地址失敗！更新時出現未知錯誤！");
		}
	}
	
	/**
	 * 統計某個用戶的收貨地址數據的數量
	 * @param uid 用户的id
	 * @return 該用戶的收貨地址數據的數量
	 */
	private Integer countByUid(Integer uid) {
		return addressMapper.countByUid(uid);
	}
	
	/**
	 * 根據用戶id查詢該用戶的收貨地址列表
	 * @param uid 用户id
	 * @return 該用戶的收貨地址列表
	 */
	private List<Address> findByUid(Integer uid) {
		return addressMapper.findByUid(uid);
	}

	/**
	 * 根據收貨地址的數據id查詢詳情
	 * @param aid 收貨地址的數據id
	 * @return 匹配的收貨地址的詳情，如果沒有匹配的數據，則返回null
	 */
	private Address findByAid(Integer aid) {
		return addressMapper.findByAid(aid);
	}

	/**
	 * 查詢某用戶最後一次修改的收貨地址數據
	 * @param uid 用户的id
	 * @return 匹配的收貨地址的詳情，如果沒有匹配的數據，則返回null
	 */
	private Address findLastModified(Integer uid) {
		return addressMapper.findLastModified(uid);
	}

}










