package com.registrationform.utils;

import com.registrationform.entity.Level;

import java.time.LocalDate;
import java.time.Period;

public class NationalIdUtils {

    private String nationalId;
    private Level level;

    public NationalIdUtils(String nationalId, Level level) {
        this.nationalId = nationalId;
        this.level = level;
    }

    public LocalDate getBirthDate(){
        int year, day, month;

        if(nationalId.charAt(0) == '2') year = 1900;
        else year = 2000;

        year += Integer.parseInt(nationalId.substring(1, 3));
        month = Integer.parseInt(nationalId.substring(3, 5));
        day = Integer.parseInt(nationalId.substring(5, 7));

        return LocalDate.of(year, month, day);
    }

    public int getAge(){
        return calculateAge(getBirthDate(), LocalDate.now());
    }

    public String getGender(){
        if(Integer.parseInt(nationalId.substring(12, 13)) % 2 == 0) return "Female";
        else return "Male";
    }

    public boolean getState(){
        return getAge() != level.getAge();
    }

    private int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        NationalIdUtils utils = new NationalIdUtils("30003132103576", Level.LEVEL1);
        System.out.println(utils.getBirthDate());
    }

}
