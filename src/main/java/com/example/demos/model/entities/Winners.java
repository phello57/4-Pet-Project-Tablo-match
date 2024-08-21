package com.example.demos.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name="winners")
public class Winners {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PLAYER_ONE_ID")
    private Long playerOneId;
    @Column(name = "PLAYER_TWO_ID")
    private Long playerTwoId;
    @Column(name = "WINNER_ID")
    private Long winnerId;


    public Winners() {
    }

    public Winners(Long playerOne, Long playerTwo, Long playerWinner) {
        this.playerOneId = playerOne;
        this.playerTwoId = playerTwo;
        this.winnerId = playerWinner;
    }

    public Long getPlayerOneId() {
        return playerOneId;
    }

    public Long getId() {
        return id;
    }

    public void setPlayerOneId(Long playerOneId) {
        this.playerOneId = playerOneId;
    }

    public Long getPlayerTwoId() {
        return playerTwoId;
    }

    public void setPlayerTwoId(Long playerTwoId) {
        this.playerTwoId = playerTwoId;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    @Override
    public String toString() {
        return "Winners{" +
                "id=" + id +
                ", playerOneId=" + playerOneId +
                ", playerTwoId=" + playerTwoId +
                ", winnerId=" + winnerId +
                '}';
    }
}
