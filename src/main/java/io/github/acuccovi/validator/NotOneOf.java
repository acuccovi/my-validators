/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validate that the value provided is not included in the list of chosen values.
 *
 * @author Alessio Cuccovillo
 * @version 1.0.0
 */
@Constraint(validatedBy = NotOneOfConstraintValidator.class)
@Target( { ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface NotOneOf {

	/**
	 * A list of words used to perform the check
	 */
	String[] options();

	String message() default "{io.github.acuccovi.validator.NotOneOf.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
