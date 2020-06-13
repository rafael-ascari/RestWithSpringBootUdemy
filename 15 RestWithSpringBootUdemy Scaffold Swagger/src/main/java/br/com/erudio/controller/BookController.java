package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private PagedResourcesAssembler<BookVO> assembler;

	@ApiOperation(value = "Find all books")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"} )
	public ResponseEntity<?> findAll (
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "15") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {

		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		if (limit > 50) {limit = 50;}
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "title"));
		
		Page<BookVO> books = services.findAll(pageable);
		
		books.stream()
		.forEach(b -> b.add(
				linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		
		PagedResources<?> resources = assembler.toResource(books);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
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
