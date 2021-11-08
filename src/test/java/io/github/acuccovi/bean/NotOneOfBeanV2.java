package io.github.acuccovi.bean;

import io.github.acuccovi.validator.NotOneOf;

public class NotOneOfBeanV2 {

	@NotOneOf(options = {"Hello", "World", "Hey Joe!"}, message = "Are you sure?")
	String value;

	public NotOneOfBeanV2(String value) {

		this.value = value;
	}
}
