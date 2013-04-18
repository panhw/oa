package com.oa.common.enumeration;

/**
 * 错误级别枚举类
 * @author sunxs
 */
public enum ErrorLevelEnum {
	block {
		@Override
		String desc() {
			return "阻塞级错误";
		}
	},serious {
		@Override
		String desc() {
			return "严重错误";
		}
	},normal {
		@Override
		String desc() {
			return "一般错误";
		}
	},ignore {
		@Override
		String desc() {
			return "不影响";
		}
	};
	
	abstract String desc();
}
