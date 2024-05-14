package io.github.lberaldi.microservices.controllers;

import io.github.lberaldi.microservices.converters.NumberConverter;
import io.github.lberaldi.microservices.exceptions.UnsupportedMathOperationException;
import io.github.lberaldi.microservices.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double mult(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double media(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo)) ;
    }

    @RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
    public double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception {
        if(!NumberConverter.isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Digite um valor numérico");
        }
        return math.raiz(NumberConverter.convertToDouble(numberOne)) ;
    }



}
