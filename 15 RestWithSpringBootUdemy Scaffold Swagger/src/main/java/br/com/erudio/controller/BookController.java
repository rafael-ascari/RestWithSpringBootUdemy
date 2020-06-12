package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Book Endpoint", description = "Descrição do endpoit dos livros", tags = {"BookEndpoint"} )
@Api(tags = {"BookEndpoint"} )
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
	
	@Autowired
	BookServices services;
	
	@ApiOperation(value = "Find all books")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BookVO> findAll() {
		List<BookVO> books = services.findAll();
		books.stream()
			.forEach(b -> b.add(
					linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		return books;
	}

	@ApiOperation(value = "Find book by ID")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BookVO findById(
			@PathVariable(value = "id") Long id) {
		BookVO vo = services.findById(id);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	@ApiOperation(value = "Create new book")
	@PostMapping(
			produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"} )
	public BookVO create(@RequestBody BookVO book) {
		BookVO vo = services.create(book);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}

	@ApiOperation(value = "Update a book")
	@PutMapping(
			produces = {"application/json", "application/xml", "application/x-yaml"},
			consumes = {"application/json", "application/xml", "application/x-yaml"} )
	public BookVO update(@RequestBody BookVO book) {
		BookVO vo = services.update(book);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	@ApiOperation(value = "Delete a book")
	@DeleteMapping("/{id}")
	public void delete(
			@PathVariable(value = "id") Long id) {
		services.delete(id);
	}
	
	
}
