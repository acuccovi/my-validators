/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.bean;

import io.github.acuccovi.validator.OneOf;

public class OneOfBeanV2 {

	@OneOf(options = {"Hello", "World", "Hey Joe!"}, ignoreCase = true, message = "Are you sure?")
	String value;

	public OneOfBeanV2(String value) {

		this.value = value;
	}
}
