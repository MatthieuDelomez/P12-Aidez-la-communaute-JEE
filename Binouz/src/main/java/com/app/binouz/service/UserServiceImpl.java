package com.app.binouz.service;

import com.app.binouz.dao.RoleRepository;
import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Classe qui va nous permettre d'implémenter notre interface UserService et
 * nottament de configurer la méthode save pour enregistrer l'utilisateur en
 * base de données
 *
 * @author Matthieu Delomez
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    /*
    Injection du repository relatif à l'utilisateur
     */
    @Autowired
    private UserRepository userRepository;

    /*
    Injection du repository relatif à la définition des rôles
     */
    @Autowired
    private RoleRepository roleRepository;

    /*
    Injection du mot de passe crypté via BCryptPasswordEncoder
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
    * Paramètrage de la méthode save où nous allons nottament définir le 
    * rôle de l'utilisateur qui sera ajouté en base de données.
    * C'est à dire le ROLE_USER
    */
    @Override
    public void save(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRoles(new HashSet<>(roleRepository.findByRole("ROLE_USER")));
        userRepository.save(user);

    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
