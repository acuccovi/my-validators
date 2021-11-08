package io.github.acuccovi.validator;

import io.github.acuccovi.bean.EnumBean;
import io.github.acuccovi.bean.EnumBeanV2;
import org.junit.Test;

import static io.github.acuccovi.common.TestUtils.*;
import static org.junit.Assert.assertEquals;

public class EnumValueTest {

	@Test
	public void enumValueValidatorTestSuccess() {

		EnumBean bean = new EnumBean("TEST_VAL_1");
		int count = validateAndGetViolationsCount(bean);
		assertEquals(0, count);
	}

	@Test
	public void enumValueValidatorTestSuccessV2() {

		EnumBeanV2 bean = new EnumBeanV2("test_val_2");
		int count = validateAndGetViolationsCount(bean);
		assertEquals(0, count);
	}

	@Test
	public void enumValueValidatorTestFail() {

		EnumBean bean = new EnumBean("TEST_VAL");
		long violationCount = validateAndGetViolationsCountWithMessage(bean,
				"The value 'TEST_VAL' is not valid for Enum 'class io.github.acuccovi.enums.TestEnum'");
		assertEquals(1L, violationCount);
	}

	@Test
	public void enumValueValidatorTestFailV2() {

		EnumBeanV2 beanV2 = new EnumBeanV2("WRONG_TEST_VAL");
		long violationCount = validateAndGetViolationsCountWithMessage(beanV2,
				"'class io.github.acuccovi.enums.TestEnum' does not contains 'WRONG_TEST_VAL'");
		assertEquals(1L, violationCount);
	}

}
