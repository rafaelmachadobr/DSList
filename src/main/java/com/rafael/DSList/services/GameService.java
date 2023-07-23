package com.rafael.DSList.services;

import com.rafael.DSList.dto.GameDTO;
import com.rafael.DSList.dto.GameMinDTO;
import com.rafael.DSList.entities.Game;
import com.rafael.DSList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game entity = gameRepository.findById(id).get();
        return new GameDTO(entity);
    }
}
