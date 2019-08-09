package com.app.binouz.validator;

import com.app.binouz.model.AppUser;
import com.app.binouz.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Fournir les données necessaires à l'enregistrement avec Spring Validator qui
 * implémente: org.springframework.validation.Validator
 *
 * Erreur générée grâce au fichier validation.properties
 *
 * @author Matthieu Delomez
 */
@Component
public class UserValidator implements Validator {

    /*
    * Injection de l'interface UserService
    */
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AppUser.class.equals(aClass);
    }

    /*
    * Paramètrage de la classe validate
    * qui nous permettra de configurer les différentes
    * contraintes liées à l'enregistrement d'un utilisateur
    *
    * 3 < username < 32
    * Notnull: username
    * 3 < password < 32
     */
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

    }

}
