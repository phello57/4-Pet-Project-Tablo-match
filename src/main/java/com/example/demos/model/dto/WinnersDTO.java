package com.example.demos.model.dto;

public class WinnersDTO {
    public Long id;
    public String playerOneName;
    public String playerTwoName;
    public String winnerName;

    public WinnersDTO() {
    }
    public WinnersDTO(String playerOneName, String playerTwoName, String winnerName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.winnerName = winnerName;
    }

    @Override
    public String toString() {
        return "WinnersDTO{" +
                "id=" + id +
                ", playerOneName='" + playerOneName + '\'' +
                ", playerTwoName='" + playerTwoName + '\'' +
                ", winnerName='" + winnerName + '\'' +
                '}';
    }
}
