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
import br.ufc.web.oussystem.model.OS;
import br.ufc.web.oussystem.repository.ClienteRepository;
import br.ufc.web.oussystem.repository.OSRepository;

@RestController
@RequestMapping(path = "/api/os")
@CrossOrigin
public class OSService {

	@Autowired
	private OSRepository osRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<OS> addOS(Integer idCliente, String aparelho, String marca, String corAparelho, String modelo,
			String status, String descricaoDefeito, String itensInclusos, String servico, Double valor) {
		if (idCliente == null || aparelho == null || marca == null || corAparelho == null || modelo == null
				|| status == null || descricaoDefeito == null || itensInclusos == null || servico == null
				|| valor == null) {
			return new ResponseEntity<OS>(HttpStatus.BAD_REQUEST);
		}
		
		Cliente cliente = clienteRepository.findById(idCliente).get();

		OS os = new OS(cliente, aparelho, marca, corAparelho, modelo, status, descricaoDefeito, itensInclusos, servico,
				valor);

		os = osRepository.save(os);
		return new ResponseEntity<OS>(os, HttpStatus.CREATED);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OS>> getAllos(@RequestParam(required = false) String status) {
		List<OS> os;
		if (status != null) {
			os = osRepository.findByStatus(status);
		} else
			os = osRepository.findAll();
		return new ResponseEntity<List<OS>>(os, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<OS> getOSById(@PathVariable("id") Integer id) {
		Optional<OS> optional = osRepository.findById(id);

		if (!optional.isPresent()) {
			return new ResponseEntity<OS>(HttpStatus.NOT_FOUND);
		}

		OS os = optional.get();
		return new ResponseEntity<OS>(os, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<OS> updateOS(@PathVariable("id") Integer id, Cliente cliente, String aparelho, String marca,
			String corAparelho, String modelo, String status, String descricaoDefeito, String itensInclusos,
			String servico, Double valor) {
		if (id == null || cliente == null || aparelho == null || marca == null || corAparelho == null || modelo == null
				|| status == null || descricaoDefeito == null || itensInclusos == null || servico == null
				|| valor == null) {
			return new ResponseEntity<OS>(HttpStatus.BAD_REQUEST);
		}

		Optional<OS> optional = osRepository.findById(id);

		if (!optional.isPresent()) {
			return new ResponseEntity<OS>(HttpStatus.NOT_FOUND);
		}

		OS os = new OS(id, cliente, aparelho, marca, corAparelho, modelo, status, descricaoDefeito, itensInclusos,
				servico, valor);
		os = osRepository.save(os);

		return new ResponseEntity<OS>(os, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<OS> deleteOS(@PathVariable("id") Integer id) {
		if (osRepository.existsById(id)) {
			osRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
