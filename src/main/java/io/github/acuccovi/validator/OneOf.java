package io.github.acuccovi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OneOfConstraintValidator.class)
@Target( { ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface OneOf {

	String[] options();

	String message() default "{io.github.acuccovi.validator.OneOf.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
