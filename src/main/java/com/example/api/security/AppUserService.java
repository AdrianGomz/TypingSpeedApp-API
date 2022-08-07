package com.example.api.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public void saveAppUser(AppUser appUser) {
        Optional<AppUser> appUserExist = appUserRepository.findByMail(appUser.getEmail());
        if (appUserExist.isPresent()) {
            throw new IllegalStateException("A user with this email already exist");
        } else {
            appUserRepository.save(appUser);
        }
    }

}
