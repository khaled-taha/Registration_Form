package com.registrationform.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @NotBlank(message = "${NotNull.user.firstName}")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "${NotBlank.user.lastName}")
    @Column(name = "secondName")
    private String secondName;

    @NotBlank(message = "${NotBlank.user.lastName}")
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "age")
    private int age;

    @Column(name = "level")
    private int level;

    @NotBlank(message = "${Size.user.nationalId}")
    @Size(min = 14, max = 14, message = "${Size.user.nationalId}")
    @Column(name = "nationalId", unique = true)
    private String nationalId;

    @NotBlank(message = "${NotBlank.user.darName}")
    @Column(name = "darName")
    private String darName;

    @NotBlank(message = "${Size.user.phone}")
    @Size(min = 11, max = 11, message = "${Size.user.phone}")
    @Column(name = "phone")
    private String phone;
    
    @NotBlank
    @Column(name = "city")
    private String city;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm a")
    @Column(name = "registrationDate")
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(name = "state")
    private boolean state;
}
