package com.oa.test;

import com.oa.common.utils.MD5;

public class Test {
	public static void main(String[] args) {
		System.out.println(MD5.MD5Encode("admin"));
		System.out.println(MD5.MD5Encode("deff"));
	}
}
