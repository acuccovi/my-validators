package io.github.acuccovi.validator;

import io.github.acuccovi.enums.TestEnum;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnumValueTest {

	private Validator validator;

	@Before
	public void init() {

		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void validatorTestSuccess() {

		Bean bean = new Bean("TEST_VAL_1");
		Set<ConstraintViolation<Bean>> violations = validator.validate(bean);
		assertTrue(violations.isEmpty());
	}

	@Test
	public void validatorTestSuccessV2() {

		BeanV2 bean = new BeanV2("test_val_2");
		Set<ConstraintViolation<BeanV2>> violations = validator.validate(bean);
		assertTrue(violations.isEmpty());
	}

	@Test
	public void validatorTestFail() {

		Bean bean = new Bean("TEST_VAL");
		long violationCount = validateAndGetViolationCountWithMessage(bean,
				"The value 'TEST_VAL' is not valid for Enum 'class io.github.acuccovi.enums.TestEnum'");
		assertEquals(1L, violationCount);
	}

	@Test
	public void validatorTestFailV2() {

		BeanV2 beanV2 = new BeanV2("WRONG_TEST_VAL");
		long violationCount = validateAndGetViolationCountWithMessage(beanV2,
				"'class io.github.acuccovi.enums.TestEnum' does not contains 'WRONG_TEST_VAL'");
		assertEquals(1L, violationCount);
	}

	private long validateAndGetViolationCountWithMessage(Object bean, String message) {

		return validateBean(bean).stream().filter(v -> v.getMessage().equals(message)).count();
	}

	private Set<ConstraintViolation<Object>> validateBean(Object bean) {

		return validator.validate(bean);
	}

	private static class Bean {

		@EnumValue(enumClass = TestEnum.class)
		final String enumVal;

		private Bean(String enumVal) {

			this.enumVal = enumVal;
		}
	}

	private static class BeanV2 {

		@EnumValue(enumClass = TestEnum.class, ignoreCase = true, message = "'{enumClass}' does not contains '${validatedValue}'")
		final String enumVal;

		private BeanV2(String enumVal) {

			this.enumVal = enumVal;
		}
	}
}
