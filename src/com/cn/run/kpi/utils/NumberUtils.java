package com.cn.run.kpi.utils;

import java.math.BigDecimal;

public class NumberUtils {

	public static double round(double value, int n) {
		BigDecimal bd = new BigDecimal(value);
		return bd.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
