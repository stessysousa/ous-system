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

import br.ufc.web.oussystem.model.Funcionario;
import br.ufc.web.oussystem.repository.FuncionarioRepository;

@RestController
@RequestMapping(path = "/api/funcionarios")
@CrossOrigin
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Funcionario> addFuncionario(String nome, String sobrenome, String contato, String email,
			String senha, String cargo) {
		if (nome == null || sobrenome == null || contato == null || email == null || senha == null || cargo == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.BAD_REQUEST);
		}

		Funcionario funcionario = new Funcionario(nome, sobrenome, contato, email, senha, cargo);

		funcionario = funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable("id") Integer id) {
		Optional<Funcionario> optional = funcionarioRepository.findById(id);

		if (!optional.isPresent()) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}

		Funcionario funcionario = optional.get();
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ResponseEntity<List<Funcionario>> getFuncionarioByNome(@RequestParam("nome") String nome) {
		System.out.println(nome);
		List<Funcionario> funcionarioList = funcionarioRepository.findByNome(nome);

		if (funcionarioList != null) {
			return new ResponseEntity<List<Funcionario>>(funcionarioList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable("id") Integer id, String nome, String sobrenome,
			String contato, String email, String senha, String cargo) {
		if (id == null || nome == null || sobrenome == null || contato == null || email == null || senha == null
				|| cargo == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.BAD_REQUEST);
		}

		Optional<Funcionario> optional = funcionarioRepository.findById(id);

		if (!optional.isPresent()) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}

		Funcionario funcionario = new Funcionario(id, nome, sobrenome, contato, email, senha, cargo);
		funcionario = funcionarioRepository.save(funcionario);

		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable("id") Integer id) {
		if (funcionarioRepository.existsById(id)) {
			funcionarioRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}

}
