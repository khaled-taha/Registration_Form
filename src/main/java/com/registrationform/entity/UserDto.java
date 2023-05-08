package com.registrationform.entity;


import com.registrationform.utils.ArabicUtils;
import com.registrationform.utils.NationalIdUtils;
import lombok.Data;


@Data
public class UserDto {
    private String firstName;

    private String secondName;
    private String lastName;
    private int level;
    private String nationalId;
    private String darName;
    private String phone;
    private String city;

    public static User mapFrom(UserDto dto) {
        User user = new User();
        NationalIdUtils nationalId = new NationalIdUtils(dto.nationalId, getLevel(dto.level));

        user.setFirstName(ArabicUtils.normalize(dto.firstName));
        user.setSecondName(ArabicUtils.normalize(dto.secondName));
        user.setLastName(ArabicUtils.normalize(dto.lastName));
        user.setDarName(ArabicUtils.normalize(dto.darName));
        user.setNationalId(dto.nationalId);
        user.setLevel(dto.level);
        user.setPhone(dto.phone);
        user.setCity(dto.city);
        user.setBirthDate(nationalId.getBirthDate());
        user.setAge(nationalId.getAge());
        user.setGender(nationalId.getGender());
        user.setState(nationalId.getState());
        System.out.println("User: " + user);
        return user;
    }
//
    private static Level getLevel(int level){
       return switch (level){
            case 1 -> Level.LEVEL1;
            case 2 -> Level.LEVEL2;
            case 3 -> Level.LEVEL3;
            case 4 -> Level.LEVEL4;
            case 5 -> Level.LEVEL5;
            case 6 -> Level.LEVEL6;
            case 7 -> Level.LEVEL7;
            case 8 -> Level.LEVEL8;
           default -> throw new IllegalStateException("Unexpected value: " + level);
       };
    }
}
