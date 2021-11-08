/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate that the value provided is included in the list of chosen values.
 *
 * @author Alessio Cuccovillo
 * @version 1.0.0
 */
@Constraint(validatedBy = OneOfConstraintValidator.class)
@Target( { ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface OneOf {

	/**
	 * A list of words used to perform the check
	 */
	String[] options();

	String message() default "{io.github.acuccovi.validator.OneOf.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
