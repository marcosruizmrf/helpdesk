package com.marcos.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.helpdesk.domain.Chamado;
import com.marcos.helpdesk.domain.Cliente;
import com.marcos.helpdesk.domain.Tecnico;
import com.marcos.helpdesk.domain.enums.Perfil;
import com.marcos.helpdesk.domain.enums.Prioridade;
import com.marcos.helpdesk.domain.enums.Status;
import com.marcos.helpdesk.repositories.ChamadoRepository;
import com.marcos.helpdesk.repositories.ClienteRepository;
import com.marcos.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Marcos Ruiz Freire", "12312312354", "marcos@mail.com", "994");
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Samuel Ruiz Freire", "12312312346", "samuel@mail.com", "991");
		tec2.addPerfil(Perfil.ADMIN);
		
		Tecnico tec3 = new Tecnico(null, "Gisleine Ruiz Freire", "12312312343", "gisleine@mail.com", "988");
		tec3.addPerfil(Perfil.ADMIN);
		
		Tecnico tec4 = new Tecnico(null, "Talita Ruiz Freire", "12312312356", "talita@mail.com", "996");
		tec4.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "32132132132", "torvalds@mail.com", "321");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));

		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
			
	}

}
