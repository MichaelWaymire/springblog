package com.codeup.springblog.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


@Controller
public class ChanceDiceController {
    /**
    The var (randomNumber is created outside of the getMapping. If the logic was placed here. Only
    one random number would be created.
    */
    int randomNumber;

    @GetMapping("/roll-dice")
    public String diceRoll() {
        /**
        but putting the randomNumber here it will create a new number each time
        the page is refreshed.
        */
        this.randomNumber = new Random().nextInt(6) + 1;
        return "roll-dice";
    }

    /**
     * {n} is the variable that is passed from the link on the page "roll-dice is clicked.
     * when it is clicked and the variable is picked it passed it to the getMapping for
     * rollDiceGuess.
     */
    @GetMapping("/roll-dice/{n}")

    public String roll(@PathVariable int n, Model model) {
        /**
         * model.addAttribute ( "name", name); allows the passed value accessible to the
         * html(Thymeleaf) page.
         */
        model.addAttribute("n", n);
        model.addAttribute("randomNumber", randomNumber );
        // return "rollDiceGuess points the clicked link to the correct page.
        return "rollDiceGuess";
    }
}

