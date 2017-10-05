package com.xgj.cache.initData2CacheByOriginalMap.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xgj.cache.initData2CacheByOriginalMap.dao.ArtisanServiceDao;
import com.xgj.cache.initData2CacheByOriginalMap.domain.LittleArtisan;


/**
 * 
 * 
 * @ClassName: ArtisanService
 * 
 * @Description: 
 *               ��ԭʼ��ʹ�û���ķ�ʽ��ͨ��һ��ȫ��map�����ȡ�������ݣ��´λ�ȡ����ʱ�ȴ�map����ȡ������о�ֱ�ӷ��أ����û�оʹ����ݿ���ȥ��ȡ
 *               ��Ȼ�����map�У���Ȼ���������²���ʱ��Ҫͬ���������map�е����ݡ� ���ַ�ʽ��Ȼԭʼ��������һЩ�򵥵ĳ������Ѿ�����
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��5�� ����1:16:56
 */

@Service
public class ArtisanService {
	Logger logger = Logger.getLogger(ArtisanService.class);

	public static Map<String, LittleArtisan> artisanMap = new ConcurrentHashMap<>();

	private ArtisanServiceDao artisanServiceDao;

	@Autowired
	public void setArtisanServiceDao(ArtisanServiceDao artisanServiceDao) {
		this.artisanServiceDao = artisanServiceDao;
	}

	/**
	 * 
	 * 
	 * @Title: loadData
	 * 
	 * @Description: Spring ������ʼ��ʱ����
	 * 
	 * 
	 * @return: void
	 */
	public void loadInitData() {
		logger.info("load data when program starts.");
		
		
		List<LittleArtisan> artisanList = getAllArtisan();

		for (LittleArtisan artisan : artisanList) {
			artisanMap.put(artisan.getArtisanName(), artisan);
			System.out.println("cached to artisanMap "
					+ artisan.getArtisanName());
		}
	}

	public List<LittleArtisan> getAllArtisan() {
		return artisanServiceDao.getAllArtisan();
	}
}
