package com.jjq.ap.binarytree;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/4/13
 * @desc
 */
public class Person {

    private String name;

    private Integer level;

    public Person(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
