package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double sum (
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double r = math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return r;
	}


	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double sub (
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double r = math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return r;
	}

	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double mult (
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double r = math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return r;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double div (
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}

		if (NumberConverter.convertToDouble(numberTwo) == 0) {
			throw new UnsuportedMathOperationException("Please set a numeric value and not zero!");
		}		
		
		Double r = math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return r;
	}	

	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET )
	public Double avg (
			@PathVariable(value="numberOne") String numberOne, 
			@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double r = math.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
		return r;
	}	
	
	@RequestMapping(value="/raiz/{numberOne}", method = RequestMethod.GET )
	public Double raiz (
			@PathVariable(value="numberOne") String numberOne) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		
		Double r = math.sqrt(NumberConverter.convertToDouble(numberOne));
		
		return r;
	}	
	
	
	
	
}
