package io.github.acuccovi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumValueConstraintValidator implements ConstraintValidator<EnumValue, String> {

	private List<? extends Enum<?>> values;
	private boolean ignoreCase;

	@Override
	public void initialize(EnumValue annotation) {

		values = Arrays
				.stream(annotation.enumClass().getEnumConstants())
				.collect(Collectors.toList());
		ignoreCase=annotation.ignoreCase();

		ConstraintValidator.super.initialize(annotation);
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

		return values
				.stream()
				.filter(enumValue->checkValue(enumValue, s))
				.map(v -> true)
				.findAny()
				.orElse(false);
	}

	private boolean checkValue(Enum<?> enumValue, String beanValue) {

		return ignoreCase ? enumValue.name().equalsIgnoreCase(beanValue) : enumValue.name().equals(beanValue);
	}
}
