package com.xgj.ioc.inject.construct.jihe.map;

import java.util.Map;

public class PetShop {

	private Pets pets;

	public void setPets(Pets pets) {
		this.pets = pets;
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: ��ȡ����ע���Map���������
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo() {

		Map<Object, Object> map = pets.getMap();

		for (Map.Entry<Object, Object> entry : map.entrySet()) {

			System.out.println("���Key = " + entry.getKey() + ",Ʒ��Value = "
					+ entry.getValue());

		}
	}
}
