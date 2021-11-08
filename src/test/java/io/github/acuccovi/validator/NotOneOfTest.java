package io.github.acuccovi.validator;

import io.github.acuccovi.bean.NotOneOfBean;
import io.github.acuccovi.bean.NotOneOfBeanV2;
import org.junit.Test;

import static io.github.acuccovi.common.TestUtils.validateAndGetViolationsCount;
import static io.github.acuccovi.common.TestUtils.validateAndGetViolationsCountWithMessage;
import static org.junit.Assert.assertEquals;

public class NotOneOfTest {

	@Test
	public void notOneOfValidatorTestFail() {

		NotOneOfBean bean = new NotOneOfBean("Hey Joe!");
		long count = validateAndGetViolationsCountWithMessage(bean, "The value 'Hey Joe!' is not valid'");
		assertEquals(1L, count);
	}

	@Test
	public void notOneOfValidatorTestSuccess() {

		NotOneOfBean bean = new NotOneOfBean("World!");
		int count = validateAndGetViolationsCount(bean);
		assertEquals(0, count);
	}

	@Test
	public void notOneOfValidatorTestFailV2() {

		NotOneOfBeanV2 bean = new NotOneOfBeanV2("Hey Joe!");
		long count = validateAndGetViolationsCountWithMessage(bean, "Are you sure?");
		assertEquals(1L, count);
	}
}
