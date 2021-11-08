package io.github.acuccovi.bean;

import io.github.acuccovi.enums.TestEnum;
import io.github.acuccovi.validator.EnumValue;

public class EnumBean {

	@EnumValue(enumClass = TestEnum.class)
	final String enumVal;

	public EnumBean(String enumVal) {

		this.enumVal = enumVal;
	}
}
