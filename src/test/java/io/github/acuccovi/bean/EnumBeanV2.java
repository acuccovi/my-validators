/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.bean;

import io.github.acuccovi.enums.TestEnum;
import io.github.acuccovi.validator.EnumValue;

public class EnumBeanV2 {

	@EnumValue(enumClass = TestEnum.class, ignoreCase = true, message = "'{enumClass}' does not contains '${validatedValue}'")
	final String enumVal;

	public EnumBeanV2(String enumVal) {

		this.enumVal = enumVal;
	}
}
