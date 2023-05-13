package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

  @Autowired private GameListRepository gameListRepository;
  @Autowired private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> result = gameListRepository.findAll();
    return result.stream().map(GameListDTO::new).toList();
  }

  @Transactional
  public void moveGameInList(Long listId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> list = gameRepository.searchByList(listId);

    GameMinProjection obj = list.remove(sourceIndex);
    list.add(destinationIndex, obj);

    int minimumIndex = Math.min(sourceIndex, destinationIndex);
    int maximumIndex = Math.max(sourceIndex, destinationIndex);

    for (int i = minimumIndex; i <= maximumIndex; i++) {
      gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
    }
  }
}
