package com.example.disktraderstealerjava.service.impl;

import com.example.disktraderstealerjava.entities.Game;
import com.example.disktraderstealerjava.repository.GamesRepository;
import com.example.disktraderstealerjava.service.StealerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StealerServiceImpl implements StealerService {

    @Value("${logging.batch.size}")
    Integer logBatchSize;

    @Value("${ps4.api.path}")
    private String PS4_API_PATH;

    @Value("${ps4.api.path.newest}")
    private String PS4_API_PATH_NEWEST;

    private final GamesRepository repository;

    @Override
    public void stealAllGames() {

        List<Game> allGames = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(PS4_API_PATH, String.class);

        ObjectMapper mapper = new ObjectMapper();

        try{
            JsonNode rootNode = mapper.readTree(result);
            JsonNode links = rootNode.get("links");

            int iterator = 0;

            for (JsonNode gameNode : links){
                Game game = new Game();
                game.setId(gameNode.get("id").asText());
                game.setTitle(gameNode.get("name").asText());
                game.setImageUrl(gameNode.get("images").get(0).get("url").asText());
                game.setPublisher(gameNode.get("provider_name").asText());
                game.setPsnURL("https://store.playstation.com/en-us/product/" + gameNode.get("id").asText());

                if (gameNode.has("default_sku")){
                    game.setPriceUsd(gameNode.get("default_sku").get("display_price").asText());
                }

                allGames.add(game);

                iterator++;

                if (iterator % logBatchSize == 0){
                    log.info(iterator + " games parsed");
                }
            }


        } catch (JsonProcessingException e) {
            log.error("Json processing exception occurred during the parsing of the games: " + e.getMessage());
        } catch (Exception e) {
            log.error("Exception occurred during the parsing of the games: " + e.getMessage());
        }

        repository.saveAll(allGames);
        log.info("All games where saved to the database");

    }

    @Override
    public void stealNewest() {

    }
}
