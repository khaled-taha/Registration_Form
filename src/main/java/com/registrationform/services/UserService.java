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

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void save(UserDto user){
        if(this.userRepo.findByNationalId(user.getNationalId()).isPresent()){
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
}
