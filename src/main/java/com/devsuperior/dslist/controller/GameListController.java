package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.MovementDTO;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

  @Autowired private GameListService gameListService;
  @Autowired private GameService gameService;

  @GetMapping
  public List<GameListDTO> findAll() {
    return gameListService.findAll();
  }

  @GetMapping(value = "/{listId}/games")
  public List<GameMinDTO> findByList(@PathVariable Long listId) {
    return gameService.findByList(listId);
  }

  @PostMapping(value = "/{listId}/movement")
  public void moveGameInList(@PathVariable Long listId, @RequestBody MovementDTO body) {
    gameListService.moveGameInList(listId, body.getSourceIndex(), body.getDestinationIndex());
  }
}
