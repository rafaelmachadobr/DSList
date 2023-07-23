package com.rafael.DSList.controllers;

import com.rafael.DSList.dto.GameDTO;
import com.rafael.DSList.dto.GameListDTO;
import com.rafael.DSList.dto.GameMinDTO;
import com.rafael.DSList.services.GameListService;
import com.rafael.DSList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
