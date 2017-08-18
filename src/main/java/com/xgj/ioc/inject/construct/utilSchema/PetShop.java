package com.xgj.ioc.inject.construct.utilSchema;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	public void petsInfo_Map() {

		Map<Integer, String> map = pets.getPetMap();

		for (Map.Entry<Integer, String> entry : map.entrySet()) {

			System.out.println("���Key = " + entry.getKey() + ",Ʒ��Value = "
					+ entry.getValue());
		}
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: ��ȡ����ע���List���������
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo_List() {
		for (int i = 0; i < pets.getPetList().size(); i++) {
			System.out.println("PetShop has " + pets.getPetList().get(i));
		}
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: ��ȡע���set,�������
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo_Set() {
		Set<String> set = pets.getPetSet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println("PetShop has " + it.next());
		}
	}

	/**
	 * 
	 * 
	 * @Title: petsInfo
	 * 
	 * @Description: ��ȡ����ע���Properties���������
	 * 
	 * 
	 * @return: void
	 */
	public void petsInfo_Properties() {

		Map<Object, Object> map = pets.getPetProperties();

		for (Map.Entry<Object, Object> entry : map.entrySet()) {

			System.out.println("���Key = " + entry.getKey() + ",Ʒ��Value = "
					+ entry.getValue());

		}
	}
}
