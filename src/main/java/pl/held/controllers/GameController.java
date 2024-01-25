package pl.held.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.held.models.Game;
import pl.held.models.User;
import pl.held.repositories.GameDao;
import pl.held.repositories.UserDao;

import java.util.List;

@Controller
public class GameController {
    private final GameDao gameDao;
    private final UserDao userDao;
    public GameController(GameDao gameDao, UserDao userDao){
        this.gameDao = gameDao;
        this.userDao = userDao;
    }
    @GetMapping("/newGame")
    public String createNewGame(Model model) {
        List<Game> gameList = gameDao.findAll();
        model.addAttribute("games", gameList);
        List<User> userList = userDao.findAll();
        model.addAttribute("users", userList);
        return "newGame";
    }
    @PostMapping("/newGame")
    public String postNewGame(Model model,
                              @RequestParam String gameStatus,
                              @RequestParam String gameSystem,
                              @RequestParam long userId){
        Game game = new Game();
        game.setMaster(userDao.getReferenceById(userId));
        game.setGameSystem(gameSystem);
        game.setStatus(gameStatus);
        gameDao.save(game);
        return "redirect:/showAllGames";
    }

    @GetMapping("/showAllGames")
    public String showAllGames(Model model) {
        List<Game> gameList = gameDao.findAll();
        model.addAttribute("games", gameList);
        return "gamesMenu";
    }
    @GetMapping("/deleteGame")
    public String deleteGame(Model model, @RequestParam long id){
        gameDao.deleteById(id);
        List<Game> gameList = gameDao.findAll();
        model.addAttribute("games",gameList);
        return "gamesMenu";
    }
    @GetMapping("/updateGame")
    public String updateGameGet(Model model, @RequestParam long id) {
        Game game = gameDao.getReferenceById(id);
        model.addAttribute("gameToEdit", game);
        List<Game> gameList = gameDao.findAll();
        model.addAttribute("games", gameList);
        List<User> userList = userDao.findAll();
        model.addAttribute("players", userList);
        return "updateGame";
    }
    @PostMapping("/updateGame")
    public String updateGamePost(@RequestParam String gameSystem, @RequestParam String gameStatus, @RequestParam long id, @RequestParam long userId){
        Game game = gameDao.getReferenceById(id);
        game.setStatus(gameStatus);
        game.setGameSystem(gameSystem);
        game.setMaster(userDao.getReferenceById(userId));
        gameDao.save(game);
        return "redirect:/showAllGames";
    }



    //@TODO
    //    @GetMapping("/addPlayerToGame")
}
