package io.github.acuccovi.bean;

import io.github.acuccovi.validator.NotOneOf;

public class NotOneOfBean {

	@NotOneOf(options = {"Hello", "World", "Hey Joe!"})
	String value;

	public NotOneOfBean(String value) {

		this.value = value;
	}
}
