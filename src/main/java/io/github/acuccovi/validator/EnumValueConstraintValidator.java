package io.github.acuccovi.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValueConstraintValidator implements ConstraintValidator<EnumValue, String> {

	private String[] values;
	private boolean  ignoreCase;

	@Override
	public void initialize(EnumValue annotation) {

		values = Arrays.stream(annotation.enumClass().getEnumConstants()).map(Enum::toString)
				.toArray(String[]::new);
		ignoreCase = annotation.ignoreCase();

		ConstraintValidator.super.initialize(annotation);
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

		return ignoreCase ? StringUtils.equalsAnyIgnoreCase(s, values) : StringUtils.equalsAny(s, values);
	}
}
