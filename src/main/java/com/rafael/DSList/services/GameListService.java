package com.rafael.DSList.services;

import com.rafael.DSList.dto.GameListDTO;
import com.rafael.DSList.entities.GameList;
import com.rafael.DSList.projections.GameMinProjection;
import com.rafael.DSList.repositories.GameListRepository;
import com.rafael.DSList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            System.out.println(listId);
            System.out.println(list.get(i).getId());
            System.out.println(i);
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
