package br.com.rruffer.cadastro.beneficio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rruffer.cadastro.beneficio.dto.ClienteDTO;
import br.com.rruffer.cadastro.beneficio.entity.Cliente;
import br.com.rruffer.cadastro.beneficio.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
@Tag(name = "Cadastro de clientes", description = "Seviços de consulta e cadastro de clientes")
public class CadastroResource {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{cpf}")
	@Operation(summary = "Consultar cliente", description = "Método que retorna um cliente pelo CPF")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna o cliente"),
			@ApiResponse(responseCode = "404", description = "Cliente não cadastrado"),
	})
	public ResponseEntity<ClienteDTO> consultarCliente(@PathVariable("cpf") String cpf) {
		
		ClienteDTO clienteDTO = null;
		try {
			clienteDTO = clienteService.consultar(cpf);
			if(clienteDTO == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(clienteDTO);
	}
	
	@PostMapping
	@Operation(summary = "Gravar cliente", description = "Método que persiste cliente na basse de dados")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente criado com sucesso"),
			@ApiResponse(responseCode = "420", description = "Cliente já cadastrado"),
	})
	public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
		
		try {
			Cliente cliente = clienteService.salvar(clienteDTO);
			if(cliente == null) {
				return ResponseEntity.status(420).build();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().build();
	}
	
}
