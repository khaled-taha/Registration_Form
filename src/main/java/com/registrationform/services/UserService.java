package com.registrationform.services;

import com.registrationform.entity.User;
import com.registrationform.entity.UserDto;
import com.registrationform.exception.BadRequest;
import com.registrationform.exception.RepeatedNationalId;
import com.registrationform.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserService {

    private static final String ID_REGEX = "[0-9]{14}";
    private static final String PHONE_REGEX = "[0-9]{11}";

    @Autowired
    private UserRepo userRepo;

    public void save(UserDto user){
        if(validatePhoneNumber(user.getPhone()))
            throw new BadRequest("Error: Phone must be unique and consist of 11 digits");

        if(validateId(user.getNationalId()) || this.userRepo.findByNationalId(user.getNationalId()).isPresent()){
            throw new RepeatedNationalId("Error: National ID must be unique and consist of 14 digits");
        }
        User savedUser = UserDto.mapFrom(user);
        try {
            userRepo.save(savedUser);
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new BadRequest(e.getMessage());
        }

    }

    public static boolean validateId(String id) {
        return Pattern.matches(ID_REGEX, id);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_REGEX, phoneNumber);
    }
}
