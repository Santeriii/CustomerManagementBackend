package com.example.Payroll;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>>{

	@Override
	public EntityModel<Customer> toModel(Customer employee) {

		return EntityModel.of(employee,
				linkTo(methodOn(CustomerController.class).one(employee.getId())).withSelfRel(),
				linkTo(methodOn(CustomerController.class).all()).withRel("employees"));
	}

}
