package fii.jt.lab8.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.security.SecureRandom;

@ApplicationScoped
public class RandomnessProvider {
    @Produces
    @Named("serialNumber")
    final int getRandomInteger() {
        return new SecureRandom().nextInt(100);
    }
}
