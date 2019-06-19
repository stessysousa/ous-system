package br.ufc.web.oussystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.oussystem.model.Funcionario;
import br.ufc.web.oussystem.repository.FuncionarioRepository;

@RestController
@RequestMapping(path = "/api/login")
@CrossOrigin
public class LoginService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Funcionario> realizarLogin(String email, String senha) {

		if (email == null || senha == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.BAD_REQUEST);
		}

		Funcionario funcionario = funcionarioRepository.findByEmail(email);

		if (funcionario == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.UNAUTHORIZED);
		}

		if (!funcionario.getSenha().equals(senha)) {
			return new ResponseEntity<Funcionario>(HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);

	}

}
