/*
 * My Validators
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package io.github.acuccovi.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotOneOfConstraintValidator implements ConstraintValidator<NotOneOf, String> {

    private String[] options;
    private boolean ignoreCase;

    @Override
    public void initialize(NotOneOf annotation) {

        options = annotation.options();
        ignoreCase = annotation.ignoreCase();

        ConstraintValidator.super.initialize(annotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return ignoreCase ?
                !StringUtils.equalsAnyIgnoreCase(value, options) :
                !StringUtils.equalsAny(value, options);
    }
}
