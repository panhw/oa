package com.oa.common.enumeration;

/**
 * 性别枚举类
 * @author sunxs
 */
public enum Sex {
	male{
		@Override
		public String getDesc() {
			return "男";
		}
	},
	fmail
 {
		@Override
		public String getDesc() {
			return "女";
		}
	},
	other {
		@Override
		public String getDesc() {
			return "其他";
		}
	};
	abstract String getDesc();
}
