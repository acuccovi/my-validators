package io.github.acuccovi.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OneOfConstraintValidator implements ConstraintValidator<OneOf, String> {

	private String[]	options;

	@Override
	public void initialize(OneOf annotation) {

		options = annotation.options();

		ConstraintValidator.super.initialize(annotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return StringUtils.equalsAnyIgnoreCase(value, options);
	}
}
