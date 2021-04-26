package com.lukas.ramonas.cms.Validators;

import com.lukas.ramonas.cms.DAO.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
//        return user.getPassword().equals(user.getMatchingPassword());
        boolean isValid = user.getPassword().equals(user.getMatchingPassword());
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "matchingPassword" ).addConstraintViolation(); // Bind the validation result to 'matchingPassword' attribute
        }
        return isValid;
    }
}