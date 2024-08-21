package com.example.demos.model.dao;

import com.example.demos.model.dto.UserDTO;
import com.example.demos.model.dto.WinnersDTO;
import com.example.demos.model.entities.User;
import com.example.demos.model.entities.Winners;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WinnersDAO {

    @Autowired
    Session session;

    @Autowired
    UserDAO userDAO;


    public ArrayList<WinnersDTO> getAll() {

        ArrayList<WinnersDTO> retWinners = new ArrayList<>();

        List<Winners> winnersSQL = session.createQuery("SELECT a FROM Winners a", Winners.class).getResultList();

        for (Winners winnersCurrent : winnersSQL) {
            retWinners.add( getOnId( winnersCurrent.getId() ) );
        }

        return retWinners;
    }

    public ArrayList<WinnersDTO> getOnName(UserDTO userDtoFilteredByName) {

        ArrayList<WinnersDTO> retWinners = new ArrayList<>();


        UserDTO userDTO = userDAO.getOnName(userDtoFilteredByName);
        Long id = userDTO.id;

        List<Winners> winnersSQL = session.createQuery("SELECT a FROM Winners a where a.playerOneId ="+ id+
                "  OR a.playerTwoId ="+ id
                , Winners.class).getResultList();

        for (Winners winnersCurrent : winnersSQL) {
            retWinners.add( getOnId( winnersCurrent.getId() ) );
        }

        return retWinners;
    }


    public WinnersDTO getOnId(Long id) {
        Winners winnersSQL = session.get(Winners.class, id);

        WinnersDTO retWinners = new WinnersDTO();
        retWinners.id = winnersSQL.getId();

        retWinners.playerOneName = userDAO.getOnId(winnersSQL.getPlayerOneId()).name;
        retWinners.playerTwoName = userDAO.getOnId(winnersSQL.getPlayerTwoId()).name;
        retWinners.winnerName = userDAO.getOnId(winnersSQL.getWinnerId()).name;

        return retWinners;
    }

    public void insert(WinnersDTO winnersDTO) {

        UserDTO player1 = userDAO.getOnName(new UserDTO(winnersDTO.playerOneName));
        UserDTO player2 = userDAO.getOnName(new UserDTO(winnersDTO.playerTwoName));
        UserDTO winner = userDAO.getOnName(new UserDTO(winnersDTO.winnerName));

        Winners winners = new Winners();

        winners.setPlayerOneId(player1.id);
        winners.setPlayerTwoId(player2.id);
        winners.setWinnerId(winner.id);

        session.save(winners);
    }
}
