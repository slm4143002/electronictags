package com.card.management.eleconst;

public class ElectronictagsConst {
	// 组装结果
	public static String ASSEMBLE_RESULT_OK ="1";
	// 接地结果
	public static String GROUND_CONNECTION_RESULT_OK ="1";
	// 耐压结果
	public static String WITHSTAND_VOLTAGE_RESULT_OK ="1";
	// UT结果
	public static String UT_RESULT_OK ="1";
	
	public static String ASSEMBLE_RESULT_NG ="0";
	public static String GROUND_CONNECTION_RESULT_NG ="0";
	public static String WITHSTAND_VOLTAGE_RESULT_NG ="0";
	public static String UT_RESULT_NG ="0";
	
	// 基站返回error
	public static String ESL_RESPONSE_ERROR_CODE ="1";
	
	// 访问基站最大等待时间秒
	public final  static long MAX_EXECUTION_TIME= 30;
	// 请求时间间隔毫秒
	public final  static long WAIT_TIME_INTERVAL= 1000;
}
