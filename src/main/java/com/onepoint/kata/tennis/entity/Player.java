package com.onepoint.kata.tennis.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Player {

    private String firtName;
    private String lastName;

    public Player() {
    }

    public Player(String firtName, String lastName) {
        this.firtName = firtName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return firtName.equals(player.firtName) && lastName.equals(player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firtName, lastName);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firtName='" + firtName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String displayShortIdentityPlayer(){
        return (this.firtName != null ? this.firtName.substring(0,1).toUpperCase()+". " : "---. ")
                + (this.lastName != null ? this.lastName.toUpperCase() : "-----");
    }
}
