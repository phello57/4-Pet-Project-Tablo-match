package com.example.demos.controller;

import com.example.demos.model.dao.UserDAO;
import com.example.demos.model.dto.UserDTO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MatchTabloController {


    @Autowired
    Session session;

    @Autowired
    UserDAO userDAO;

    @PostMapping(value="match")
    public String gamePage(Model model
            , @RequestParam(value = "player1", defaultValue = "") String player1
            , @RequestParam(value = "player2", defaultValue = "") String player2)
    {
        model.addAttribute("player1", player1);
        model.addAttribute("player2", player2);

        userDAO.insert(new UserDTO(player1));
        userDAO.insert(new UserDTO(player2));

        return "match";
    }
}
