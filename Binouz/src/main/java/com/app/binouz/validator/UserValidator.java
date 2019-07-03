
package com.app.binouz.validator;

import com.app.binouz.model.AppUser;
import com.app.binouz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class UserValidator implements Validator{
    
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AppUser user = (AppUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.appUser.username");
        }
        
        
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.appUser.username");
        }
        
        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 3 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.appUser.password");
        }
        
        /*

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.appUser.passwordConfirm");
        }
        */
        
       System.out.println("=======================>"  +user.getPassword() + " " + user.getUsername() + " " + user.getAdresseMail() + " " + 
                user.getNom() + " " + user.getPrenom() + " " + user.getRoles()+ "<=======================" );
    
}
    
}
