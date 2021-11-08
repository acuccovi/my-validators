package io.github.acuccovi.bean;

import io.github.acuccovi.validator.OneOf;

public class OneOfBeanV2 {

	@OneOf(options = {"Hello", "World", "Hey Joe!"}, message = "Are you sure?")
	String value;

	public OneOfBeanV2(String value) {

		this.value = value;
	}
}
