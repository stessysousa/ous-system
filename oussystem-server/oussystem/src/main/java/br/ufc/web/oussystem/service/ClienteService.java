package br.ufc.web.oussystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.oussystem.model.Cliente;
import br.ufc.web.oussystem.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/api/clientes")
@CrossOrigin
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> addCliente(String nome, String telefone1, String telefone2, String estado,
			String cidade, String endereco, String numero, String bairro) {
		if (nome == null || telefone1 == null || telefone2 == null || estado == null || cidade == null || endereco == null || numero == null || bairro == null) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}

		Cliente cliente = new Cliente(nome, telefone1, telefone2, estado, cidade, endereco, numero, bairro);

		cliente = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Cliente> getClienteByID(@PathVariable("id") Integer id){
		Optional<Cliente> optional = clienteRepository.findById(id);
		
		if (!optional.isPresent()) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}

		Cliente cliente = optional.get();
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ResponseEntity<List<Cliente>> getClienteByNome(@RequestParam("nome") String nome) {
		System.out.println(nome);
		List<Cliente> clienteList = clienteRepository.findByNome(nome);

		if (clienteList != null) {
			return new ResponseEntity<List<Cliente>>(clienteList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Integer id, String nome, String telefone1, String telefone2, String estado, String cidade, String endereco, String numero, String bairro) {
		if (nome == null || telefone1 == null || telefone2 == null || estado == null || cidade == null || endereco == null || numero == null || bairro == null) {
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<Cliente> optional = clienteRepository.findById(id);
		
		if (!optional.isPresent()) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		Cliente cliente = new Cliente(id, nome, telefone1, telefone2, estado, cidade, endereco, numero, bairro);
		cliente = clienteRepository.save(cliente);
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Integer id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
}
