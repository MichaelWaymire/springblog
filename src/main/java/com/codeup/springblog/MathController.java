package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {


        @RequestMapping(path = "/add/{number}/and/{num}", method = RequestMethod.GET)
        @ResponseBody
        public String add(@PathVariable int number,@PathVariable int num) {
            int added = number + num;
            return number + " + " + num + " = " + added;
        }

        @RequestMapping(path = "/subtract/{number}/and/{num}", method = RequestMethod.GET)
        @ResponseBody
        public String subtract(@PathVariable int number, @PathVariable int num) {
            int minus = number - num;
            return number + " - " + num + " = " + minus;
        }

        @RequestMapping(path = "/multiply/{number}/and/{num}", method = RequestMethod.GET)
        @ResponseBody
        public String multiply(@PathVariable long number, @PathVariable long num) {
            long multiply = number * num;
            return number + " * " + num + " = " + multiply;
        }

        @RequestMapping(path = "/divide/{number}/and/{num}")
        @ResponseBody
        public String divide(@PathVariable long number, @PathVariable long num) {
            long divide = number / num;
            return number + " / " + num + " = " + divide;
        }

}



