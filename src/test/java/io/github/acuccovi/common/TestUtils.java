package io.github.acuccovi.common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class TestUtils {

	private static final Validator validator;

	static {

		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	private TestUtils() {

	}

	public static int validateAndGetViolationsCount(Object bean) {

		Set<ConstraintViolation<Object>> violations = validator.validate(bean);
		return violations.size();
		//return validator.validate(bean).size();
	}

	public static long validateAndGetViolationsCountWithMessage(Object bean, String message) {

		return validateBean(bean).stream().filter(v -> v.getMessage().equals(message)).count();
	}

	public static Set<ConstraintViolation<Object>> validateBean(Object bean) {

		return validator.validate(bean);
	}
}
