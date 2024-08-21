package com.example.demos.controller;


import com.example.demos.model.dao.UserDAO;
import com.example.demos.model.dao.WinnersDAO;
import com.example.demos.model.dto.UserDTO;

import com.example.demos.service.NumirableTableRowsByPageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.example.demos.settings.Errors.NoDataFoundOnFilter;

@Controller
public class MatchScoreController {


    @Autowired
    WinnersDAO winnersDAO;

    @Autowired
    UserDAO userDAO;

    @GetMapping(value="matches")
    public String tableOfScorePage(@RequestParam(defaultValue = "1") int page, Model model){

        NumirableTableRowsByPageService serv = new NumirableTableRowsByPageService();

        List<ArrayList<Object>> printedWinners = serv.cutForOnePage(winnersDAO.getAll(), page);

        model.addAttribute("winners", printedWinners);
        model.addAttribute("page", page);


        return "matches";
    }


    @PostMapping(value="matches")
    public String add(@RequestParam String filter, @RequestParam(defaultValue = "1") String page, Model model) {

        List<ArrayList<Object>> outputDataWinners = null;
        UserDTO userDtoFromFilter = new UserDTO(filter);
        NumirableTableRowsByPageService serv = new NumirableTableRowsByPageService();


        boolean isDataFound = false;
        boolean isUserEntity = userDAO.getOnName(userDtoFromFilter) != null;
        boolean isFilterEmpty = filter.equals("");

        if (isUserEntity) {
            outputDataWinners = serv.cutForOnePage(winnersDAO.getOnName(userDtoFromFilter), Integer.parseInt(page));
            isDataFound = true;

        } else if (isFilterEmpty) {
            outputDataWinners = serv.cutForOnePage(winnersDAO.getAll(), Integer.parseInt(page));
            isDataFound = true;
        }


        if (isDataFound) {
            model.addAttribute("winners", outputDataWinners);
            model.addAttribute("page", page);
            model.addAttribute("filter", filter);
        } else {
            model.addAttribute("errorMessage", NoDataFoundOnFilter);
        }

        return "matches";
    }
}
