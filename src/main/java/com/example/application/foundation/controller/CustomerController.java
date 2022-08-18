package com.example.application.foundation.controller;

import com.example.application.common.controller.CommonController;
import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;
import com.example.application.foundation.dtos.CustomerDto;
import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
@Api(value = "Simple Spring Boot REST API of Customers")
@CrossOrigin(origins = "*")
public class CustomerController extends CommonController {

    private CustomerService service;
    private ModelMapper modelMapper;


    @ApiOperation(value = "Retorna um id de Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um id de Customer"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable UUID id) {

        Optional<Customer> customerData = null;
        try {
            customerData = service.findById(id);
            if (!customerData.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
        } catch (BusinessException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (TechnicalException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }


    @ApiOperation(value = "Salva um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Salva um Customer"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
    })
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CustomerDto customerDto) {
        try {
            Customer customer = modelMapper.map(customerDto, Customer.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customer));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Deleta um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Deleta um Customer"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Retorna uma Lista um Customer dentro de uma pagina")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista um Customer dentro de uma pagina"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
    })
    @GetMapping
    public ResponseEntity<Page<Customer>> listAllPageable(@PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            Page<Customer> pageCustomer = service.listAllPageable(pageable);
            if (pageCustomer.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.ok(pageCustomer);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Retorna uma Lista um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma Lista um Customer"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
    })
    @GetMapping(path = "/all")
    public ResponseEntity<List<Customer>> listlistAllNonPageable() {
        try {
            List<Customer> listCustomer = service.listlistAllNonPageable();
            if (listCustomer.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.ok(listCustomer);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @ApiOperation(value = "Atualiza um Customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza um Customer"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Customer> replace(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
        Optional<Customer> customerData = null;
        try {
            customerData = service.findById(id);
            if (!customerData.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Customer customerUpdate = service.save(customer);
        return new ResponseEntity<>(customerUpdate, HttpStatus.OK);


    }


}
