package com.example.disktraderstealerjava.repository;

import com.example.disktraderstealerjava.entities.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends CrudRepository<Game, String> {

}
