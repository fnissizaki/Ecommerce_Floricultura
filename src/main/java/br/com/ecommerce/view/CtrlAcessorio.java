package br.com.ecommerce.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.controle.ConsultarAcessorioCommand;
import br.com.ecommerce.controle.SalvarAcessorioCommand;
import br.com.ecommerce.model.domain.Acessorio;

@RestController 
@RequestMapping("/acessorios")
public class CtrlAcessorio {
	
	@Autowired
	private ConsultarAcessorioCommand consAcesCmd;
	
	@Autowired
	private SalvarAcessorioCommand salvarAcesCmd;

	@GetMapping
	public List <Acessorio> obterAcessorios(){
		Acessorio acessorio= new Acessorio();
		return (List<Acessorio>) consAcesCmd.executar(acessorio);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@RequestBody Acessorio acessorio) {
		
		salvarAcesCmd.executar(acessorio);
		
	}
}
