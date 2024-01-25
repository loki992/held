package pl.held.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.held.models.Character;
import pl.held.models.User;
import pl.held.repositories.CharacterDao;
import pl.held.repositories.UserDao;

import java.util.List;
import java.util.Objects;

@Controller
public class CharacterController {

    private final CharacterDao characterDao;
    private final UserDao userDao;

    public CharacterController(CharacterDao characterDao, UserDao userDao) {
        this.characterDao = characterDao;
        this.userDao = userDao;
    }

    @GetMapping("/showAllChars")
    public String showAllCharacters(Model model) {
        List<Character> characterList = characterDao.findAll();
        model.addAttribute("characters", characterList);
        return "showAll";
    }

    @GetMapping("/newCharacter")
    public String newCharacterForm(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "new";
    }

    @PostMapping("/newCharacter")
    public String newCharacter(@RequestParam int age,
                               @RequestParam String birthPlace,
                               @RequestParam int dex,
                               @RequestParam int edu,
                               @RequestParam int fit,
                               @RequestParam int hp,
                               @RequestParam String job,
                               @RequestParam String homeCity,
                               @RequestParam int mov,
                               @RequestParam int looks,
                               @RequestParam int luck,
                               @RequestParam int intel,
                               @RequestParam int mp,
                               @RequestParam String charName,
                               @RequestParam int phys,
                               @RequestParam long user,
                               @RequestParam int pw,
                               @RequestParam int sanity,
                               @RequestParam int str,
                               @RequestParam String charSurname,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        Character character = new Character();
        character.setUser(userDao.getReferenceById(user));
        character.setAge(age);
        character.setBirthCity(birthPlace);
        character.setDexterity(dex);
        character.setEducation(edu);
        character.setFitness(fit);
        character.setHp(hp);
        character.setJob(job);
        character.setHomeCity(homeCity);
        character.setMovement(mov);
        character.setLooks(looks);
        character.setLuck(luck);
        character.setInteligence(intel);
        character.setMp(mp);
        character.setName(charName);
        character.setPhysique(phys);
        character.setPower(pw);
        character.setSanity(sanity);
        character.setStrength(str);
        character.setSurname(charSurname);

        redirectAttributes.addFlashAttribute("character", character);

        return "redirect:/tryToCreate";
    }

    @GetMapping("/tryToCreate")
    public String tryToCreate(Model model,
                              @Valid @ModelAttribute Character character,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "dataInputError";
        } else {
            characterDao.save(character);
            model.addAttribute("charId", character.getId());

            return "created";
        }
    }

    @GetMapping("/show")
    public String showCharacterSheet(Model model, @RequestParam(name = "id") String characterId) {
        Character character = characterDao.getReferenceById(Long.valueOf(characterId));
        model.addAttribute("character", character);
        model.addAttribute("owner", userDao.getReferenceById(character.getUser().getId()));
        System.out.println(character.getId());

        return "showCharacterSheet";
    }

    @GetMapping("/delete")
    public String deleteCharacter(Model model, @RequestParam long id, @RequestParam String sure) {
        if (Objects.equals(sure, "yes")) {
            characterDao.deleteById(id);
            return "done";
        } else {
            model.addAttribute("id", id);
            return "deleteCharacter";
        }
    }

    @GetMapping("/update")
    public String updateCharacter(Model model, @RequestParam long id) {
        Character character = characterDao.getReferenceById(id);
        model.addAttribute("characterToEdit", character);
        return "updateCharacter";
    }

}
