package com.registrationform.entity;

public enum Level {
    LEVEL1(20),
    LEVEL2(18),
    LEVEL3(15),
    LEVEL4(12),
    LEVEL5(10),
    LEVEL6(8),
    LEVEL7(6),
    LEVEL8(5);

    private int age;

    Level(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
