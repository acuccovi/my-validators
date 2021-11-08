package io.github.acuccovi.bean;

import io.github.acuccovi.validator.OneOf;

public class OneOfBean {

	@OneOf(options = {"Hello", "World", "Hey Joe!"})
	String value;

	public OneOfBean(String value) {

		this.value = value;
	}
}
