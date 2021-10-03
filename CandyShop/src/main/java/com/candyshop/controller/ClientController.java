package com.candyshop.controller;

import com.candyshop.model.form.ClientForm;
import com.candyshop.model.Client;
import com.candyshop.model.dto.ClientDto;
import com.candyshop.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<Client> listAllClient(){
        return clientRepository.findAll();
    }
    //@Valid - O Spring dispara as validações do Bean Validation.
    @PostMapping("/post")
    public ResponseEntity<?> registerClient(@RequestBody @Valid ClientForm clientForm, UriComponentsBuilder uriComponentsBuilder)
    {
        Client client = modelMapper.map(clientForm, Client.class);
        clientRepository.save(client);
        modelMapper.map(client, ClientDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //@GetMapping pode ser usado para definir um path dinâmico no endereço.
    //@PathVariable é utilizado para recebermos parâmetros dinâmicos no "path".
    @GetMapping("/{id}")
    public ResponseEntity<?> findClientById(@PathVariable Long id)
    {
        Client client = clientRepository.getById(id);
        modelMapper.map(client, ClientDto.class);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }

    //@PutMapping é responsável pelas requisições do tipo PUT, atualizações por Id, etc.
    @PutMapping("/{id}")
    @Transactional // aplicar o "commit" automático na transação, caso não ocorra uma "exception" e, também, aplicar o método dentro de um contexto transacional.
    public ResponseEntity<?> update(@PathVariable @Valid Long id, @RequestBody @Valid ClientForm clientForm)
    {
        Client client = modelMapper.map(clientForm, Client.class);
        clientRepository.save(client);
        modelMapper.map(client, ClientDto.class);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    //@DeleteMapping é responsável pela exclusão de recursos.
    @DeleteMapping("/{id}")
    @Transactional // aplicar o "commit" automático na transação, caso não ocorra uma "exception" e, também, aplicar o método dentro de um contexto transacional.
    public ResponseEntity<?> remove(@Valid @PathVariable Long id)
    {
        Client client = clientRepository.getById(id);
        this.clientRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}



