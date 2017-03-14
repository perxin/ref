package com.ref.base.util;

import java.math.BigDecimal;

public class DoubleUtil {

	/**
	 * @description 加法运算
	 * @author xin
	 * @date 2016年11月14日 上午10:10:07
	 * @param v1 被加数
	 * @param v2 加数
	 * @return
	 */
	public static double sum(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * @description 减法运算
	 * @author xin
	 * @date 2016年11月14日 上午10:11:18
	 * @param v1 被减数
	 * @param v2 减数
	 * @return
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	
	/**
	 * @description 乘法运算
	 * @author xin
	 * @date 2016年11月14日 上午10:12:24
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return
	 */
	public static double multiply(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	
	/**
	 * @description 除法运算.由scale参数指定精度，以后的数字四舍五入
	 * @author xin
	 * @date 2016年11月14日 上午10:13:39
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精度
	 * @return
	 */
	public static double divide(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(sum(1.56, 9.25));
		System.out.println(sub(11.5624, 9.25));
		System.out.println(divide(120.4, 2, 4));
		System.out.println(divide(11.5624, 9.25,5));
	}
}
