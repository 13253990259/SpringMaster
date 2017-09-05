package com.xgj.aop.spring.advisor.aspectJ.function.atwithin2;

/**
 * 
 * 
 * @ClassName: Waiter
 * 
 * @Description: ��ע@Monitorable������֤���¹۵㣺
 *               �����ע��@Mע�����һ���ӿڣ�������ʵ�ָýӿڵ��ಢ��ƥ��@within(M) .
 *               ����ӿ�Waiter��ע��@Markע�⣬
 *               ��������ʵ����NaiveWaiter��NaughtyWaiter��Щ�ӿ�ʵ�������б�ע@Mark,
 *               ��@within(com.xgj.Mark) ��
 *               @target(com,xgj.Mark)����ƥ��NaiveWaiter��NaughtyWaiter�� ��Ϊ@within()
 *               @target() @annotation�����������Ŀ������Եģ������������ʱ���������Ͷ��ԡ� ��Ҫ�ر�ע�⡣
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017��9��5�� ����6:09:56
 */
@Monitorable
public interface Waiter {
	public void greetTo(String clientName);

}
