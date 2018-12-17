package com.zgg.web.common.code;


/**
 * @author Administrator
 * desc
 */
public enum CodeEC implements CodeI {
	
	/**
	 *错误码规范：
	 *1XXXXX：公共错误
	 *2XXXXX：用户模块
	 */
	
	/**公共模块*/
	SUCCESS("0", "成功"),
	PARAM_INVALID("1", "参数无效"),
	DB_ERROR("2", "数据库错误"),
	NONE("3", "未知错误"),
	/**用户模块*/
	UNKOWN_ERRERE("200000","未知错误"),
	ORDER_UNPAID("200001","该订单未支付，不能进行关联该订单");

	private String code;
	private String name;

	private CodeEC(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}
}
