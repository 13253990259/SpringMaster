package com.xgj.ioc.configuration.lstmpSupport;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

	private List<Plugin> plugins;

	private Map<String, Plugin> pluginMap;

	// Spring�Ὣ��������������ΪPlugin��Beanע�뵽���������
	@Autowired(required = false)
	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}

	// ��Plugin���͵�Beanע�뵽Map��
	@Autowired
	public void setPluginMap(Map<String, Plugin> pluginMap) {
		this.pluginMap = pluginMap;
	}

	/**
	 * 
	 * 
	 * @Title: getPlugins
	 * 
	 * @Description: ��ȡPlugins
	 * 
	 * @return
	 * 
	 * @return: List<Plugin>
	 */
	public List<Plugin> getPlugins() {
		return plugins;
	}

	/**
	 * 
	 * 
	 * @Title: getPluginMap
	 * 
	 * @Description: ��ȡMap
	 * 
	 * @return
	 * 
	 * @return: Map<String,Plugin>
	 */
	public Map<String, Plugin> getPluginMap() {
		return pluginMap;
	}

}
