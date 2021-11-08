/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NotOneOfConstraintValidator implements ConstraintValidator<NotOneOf, String> {

	private String[]	options;

	@Override
	public void initialize(NotOneOf annotation) {

		options = annotation.options();

		ConstraintValidator.super.initialize(annotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return !StringUtils.equalsAnyIgnoreCase(value, options);
	}
}
