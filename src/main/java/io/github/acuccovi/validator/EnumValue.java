package io.github.acuccovi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueConstraintValidator.class)
public @interface EnumValue {

	Class<? extends Enum<?>> enumClass();

	boolean ignoreCase() default false;

	String message() default "{io.github.acuccovi.validator.EnumValue.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
