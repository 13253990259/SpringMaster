package com.xgj.cache.initData2CacheByOriginalMap;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.xgj.cache.initData2CacheByOriginalMap.service.ArtisanService;

/**
 * 
 * 
 * @ClassName: CacheBeanPostProcessor
 * 
 * @Description: @Component��ע����Spring�����Bean
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��10��5�� ����11:27:38
 */

@Component
public class CacheBeanPostProcessor implements BeanPostProcessor {

	Logger logger = Logger.getLogger(CacheBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {

		logger.info("call postProcessBeforeInitialization");
		if (bean instanceof ArtisanService) {
			((ArtisanService) bean).loadInitData();
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info("call postProcessAfterInitialization");
		return bean;
	}

}
