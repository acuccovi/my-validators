/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import io.github.acuccovi.bean.OneOfBean;
import io.github.acuccovi.bean.OneOfBeanV2;
import org.junit.Test;

import static io.github.acuccovi.common.TestUtils.validateAndGetViolationsCount;
import static io.github.acuccovi.common.TestUtils.validateAndGetViolationsCountWithMessage;
import static org.junit.Assert.assertEquals;

public class OneOfTest {

	@Test
	public void notOneOfValidatorTestFail() {

		OneOfBean bean = new OneOfBean("Hey Joe");
		long count = validateAndGetViolationsCountWithMessage(bean, "The value 'Hey Joe' is not valid'");
		assertEquals(1L, count);
	}

	@Test
	public void notOneOfValidatorTestSuccess() {

		OneOfBean bean = new OneOfBean("World");
		int count = validateAndGetViolationsCount(bean);
		assertEquals(0, count);
	}

	@Test
	public void notOneOfValidatorTestFailV2() {

		OneOfBeanV2 bean = new OneOfBeanV2("Hey Joe");
		long count = validateAndGetViolationsCountWithMessage(bean, "Are you sure?");
		assertEquals(1L, count);
	}

	@Test
	public void notOneOfValidatorTestFailV2IgnoringCase() {

		OneOfBeanV2 bean = new OneOfBeanV2("Hey Joe");
		long count = validateAndGetViolationsCountWithMessage(bean, "Are you sure?");
		assertEquals(1L, count);
	}
}
