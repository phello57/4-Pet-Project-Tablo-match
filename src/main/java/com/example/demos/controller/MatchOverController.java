package com.example.demos.controller;

import com.example.demos.model.dao.WinnersDAO;
import com.example.demos.model.dto.WinnersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatchOverController {

    @Autowired
    WinnersDAO winnersDAO;
    @GetMapping(value="match-over")
    public String gameOverPage(@RequestParam(value = "player1", defaultValue = "") String player1
                              , @RequestParam(value = "player1Score", defaultValue = "") String player1Score
                              , @RequestParam(value = "player2", defaultValue = "") String player2
                              , @RequestParam(value = "player2Score", defaultValue = "") String player2Score
                              , @RequestParam(value = "winner", defaultValue = "") String winner
                              , Model model){


        WinnersDTO winnersDTO = new WinnersDTO(player1, player2, winner);

        winnersDAO.insert(winnersDTO);

        model.addAttribute("player1", player1);
        model.addAttribute("player1Score", player1Score);
        model.addAttribute("player2", player2);
        model.addAttribute("player2Score", player2Score);
        model.addAttribute("winner", winner);



        return "match-over";
    }
}
