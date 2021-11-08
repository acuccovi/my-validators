/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Validate that the value provided is valid for the enum stated as enumClass.
 *
 * @author Alessio Cuccovillo
 * @version 1.0.0
 */
@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueConstraintValidator.class)
public @interface EnumValue {

	/**
	 * The Enum class used to validate the input string
	 */
	Class<? extends Enum<?>> enumClass();

	/**
	 * Indicates whether ignore the case of the input sting when validating
	 * Default false
	 */
	boolean ignoreCase() default false;

	String message() default "{io.github.acuccovi.validator.EnumValue.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
