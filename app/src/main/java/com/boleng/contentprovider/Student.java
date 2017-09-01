package com.boleng.contentprovider;

/**
 * Created by boleng on 8/28/17.
 */

public class Student {

    private String name;
    private int age;
    private String introduce;

    public Student(String name, int age, String introduce) {
        this.name = name;
        this.age = age;
        this.introduce = introduce;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
