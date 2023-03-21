package com.proyectcens.springbootcens.utils;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;
import com.proyectcens.springbootcens.model.Authority;
import com.proyectcens.springbootcens.model.User;
import com.proyectcens.springbootcens.repositories.AuthorityRepository;
import com.proyectcens.springbootcens.repositories.UserRepository;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)));
        }

        if (this.userRepository.count() == 0) {
            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                    new User("tomas.sureda", encoders.encode("tasq2801"),List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("duvan.apiolaza", encoders.encode("duvaap2801"),List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("mathias.navarrete", encoders.encode("mathiasn2801"),List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
             ));
        }
    }

}
