package io.github.acuccovi.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NotOneOfConstraintValidator.class)
@Target( { ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface NotOneOf {

	String[] options();

	String message() default "{io.github.acuccovi.validator.NotOneOf.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
