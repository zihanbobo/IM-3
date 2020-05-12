package com.jiangfucheng.im.common.constants;

/**
 * Created by IntelliJ IDEA.
 * Date: 2020/5/10
 * Time: 16:16
 *
 * @author jiangfucheng
 */
public final class ResponseCode {
	public static final Integer OK = 0;
	public static final String OK_MSG = "ok";
	public static final Integer UNKNOWN_ERROR = -1;
	public static final String UNKNOWN_DEFAULT_MSG = "未知异常";
	public static final Integer PARAMTER_ERROR = -2;
	public static final String PARAMTER_ERROR_DEFAULT_MSG = "参数错误";

	private ResponseCode() {
	}
}
