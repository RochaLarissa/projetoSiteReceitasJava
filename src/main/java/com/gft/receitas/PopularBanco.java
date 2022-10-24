package com.gft.receitas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gft.receitas.entities.Ingrediente;
import com.gft.receitas.entities.Item;
import com.gft.receitas.entities.Receita;
import com.gft.receitas.entities.UnidadeMedida;
import com.gft.receitas.entities.Usuario;
import com.gft.receitas.repositories.IngredienteRepository;
import com.gft.receitas.repositories.ItemRepository;
import com.gft.receitas.repositories.ReceitaRepository;
import com.gft.receitas.repositories.UnidadeMedidaRepository;
import com.gft.receitas.repositories.UsuarioRepository;

@Component
public class PopularBanco implements CommandLineRunner{
	
	@Autowired
	UnidadeMedidaRepository unidadeMedidaRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ReceitaRepository receitaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		UnidadeMedida xicara = new UnidadeMedida();
		xicara.setTipoUnidadeMedida("xícara");
		unidadeMedidaRepository.save(xicara);
		
		UnidadeMedida colherSopa = new UnidadeMedida();
		colherSopa.setTipoUnidadeMedida("colher de sopa");
		unidadeMedidaRepository.save(colherSopa);
		
		UnidadeMedida unds = new UnidadeMedida();
		unds.setTipoUnidadeMedida("unidades");
		unidadeMedidaRepository.save(unds);
		
		UnidadeMedida und = new UnidadeMedida();
		und.setTipoUnidadeMedida("unidade");
		unidadeMedidaRepository.save(und);

		UnidadeMedida ml = new UnidadeMedida();
		ml.setTipoUnidadeMedida("ml");
		unidadeMedidaRepository.save(ml);

		UnidadeMedida copo = new UnidadeMedida();
		copo.setTipoUnidadeMedida("copo");
		unidadeMedidaRepository.save(copo);

		UnidadeMedida agosto = new UnidadeMedida();
		agosto.setTipoUnidadeMedida("à gosto");
		unidadeMedidaRepository.save(agosto);

		UnidadeMedida qtbaste = new UnidadeMedida();
		qtbaste.setTipoUnidadeMedida("quanto baste");
		unidadeMedidaRepository.save(qtbaste);
		
		Ingrediente cebola = new Ingrediente();
		cebola.setNomeIngrediente("cebola");
		ingredienteRepository.save(cebola);
		
		Ingrediente cremeLeite = new Ingrediente();
		cremeLeite.setNomeIngrediente("creme de leite");
		ingredienteRepository.save(cremeLeite);

		Ingrediente polvilhoDoce = new Ingrediente();
		polvilhoDoce.setNomeIngrediente("polvilho doce");
		ingredienteRepository.save(polvilhoDoce);
		
		Ingrediente farinhaTrigo = new Ingrediente();
		farinhaTrigo.setNomeIngrediente("farinha de trigo");
		ingredienteRepository.save(farinhaTrigo);

		Ingrediente fermentoQuimico = new Ingrediente();
		fermentoQuimico.setNomeIngrediente("fermento químico");
		ingredienteRepository.save(fermentoQuimico);
		
		Ingrediente cenoura = new Ingrediente();
		cenoura.setNomeIngrediente("cenoura");
		ingredienteRepository.save(cenoura);
		
		Ingrediente leite = new Ingrediente();
		leite.setNomeIngrediente("leite");
		ingredienteRepository.save(leite);

		Ingrediente queijoRalado = new Ingrediente();
		queijoRalado.setNomeIngrediente("queijo ralado");
		ingredienteRepository.save(queijoRalado);
		
		Ingrediente ovos = new Ingrediente();
		ovos.setNomeIngrediente("ovos");
		ingredienteRepository.save(ovos);

		Ingrediente oleo = new Ingrediente();
		oleo.setNomeIngrediente("óleo");
		ingredienteRepository.save(oleo);
		
		Ingrediente acucar = new Ingrediente();
		acucar.setNomeIngrediente("açúcar");
		ingredienteRepository.save(acucar);
		
		Ingrediente oregano = new Ingrediente();
		oregano.setNomeIngrediente("orégano");
		ingredienteRepository.save(oregano);
		
		Ingrediente sal = new Ingrediente();
		sal.setNomeIngrediente("sal");
		ingredienteRepository.save(sal);
		
		Ingrediente agua = new Ingrediente();
		agua.setNomeIngrediente("água");
		ingredienteRepository.save(agua);
		
		Item it1 = new Item();
		it1.setQtdIngrediente("1/2");
		it1.setUnidadeMedida(xicara);
		it1.setIngrediente(oleo);
		itemRepository.save(it1);
		
		Item it2 = new Item();
		it2.setQtdIngrediente("3");
		it2.setUnidadeMedida(und);
		it2.setIngrediente(cenoura);
		itemRepository.save(it2);
		
		Item it3 = new Item();
		it3.setQtdIngrediente("4");
		it3.setUnidadeMedida(und);
		it3.setIngrediente(ovos);
		itemRepository.save(it3);

		Item it4 = new Item();
		it4.setQtdIngrediente("2");
		it4.setUnidadeMedida(xicara);
		it4.setIngrediente(acucar);
		itemRepository.save(it4);
		
		Item it5 = new Item();
		it5.setQtdIngrediente("2 e 1/2");
		it5.setUnidadeMedida(xicara);
		it5.setIngrediente(farinhaTrigo);
		itemRepository.save(it5);

		Item it6 = new Item();
		it6.setQtdIngrediente("1");
		it6.setUnidadeMedida(colherSopa);
		it6.setIngrediente(fermentoQuimico);
		itemRepository.save(it6);
		
		//Receita 1
		Receita r1 = new Receita();
		r1.setNomeReceita("Bolo de cenoura");		
		
		List<Item> lista1 = new ArrayList<>();
		lista1.add(it1);
		lista1.add(it2);
		lista1.add(it3);
		lista1.add(it4);
		lista1.add(it5);
		lista1.add(it6);
		r1.setListaIngredientes(lista1);
		r1.setListaItemStringona(" ");
		
		
		r1.setModoPreparo("Em um liquidificador, adicione a cenoura ralada, os ovos e o óleo, depois misture.\r\n"
				+ "\r\n"
				+ "Acrescente o açúcar e bata novamente por 5 minutos.\r\n"
				+ "\r\n"
				+ "Em uma tigela ou na batedeira, adicione a farinha de trigo e depois misture novamente.\r\n"
				+ "\r\n"
				+ "Acrescente o fermento e misture lentamente com uma colher.\r\n"
				+ "\r\n"
				+ "Asse em um forno preaquecido a 180° C por aproximadamente 40 minutos.");
		r1.setDificuldade("Intermediário");
		r1.setRendimento("10 pessoas");
		r1.setTempoPreparo("1h");
		receitaRepository.save(r1);
		
		
		//Receita 2
		Item it1r2 = new Item();
		it1r2.setQtdIngrediente("200");
		it1r2.setUnidadeMedida(ml);
		it1r2.setIngrediente(cremeLeite);
		itemRepository.save(it1r2);

		Item it2r2 = new Item();
		it2r2.setQtdIngrediente("1");
		it2r2.setUnidadeMedida(xicara);
		it2r2.setIngrediente(queijoRalado);
		itemRepository.save(it2r2);

		Item it3r2 = new Item();
		it3r2.setQtdIngrediente("1");
		it3r2.setUnidadeMedida(xicara);
		it3r2.setIngrediente(polvilhoDoce);
		itemRepository.save(it3r2);
		
		Receita r2 = new Receita();
		r2.setNomeReceita("Pão de queijo");
		
		List<Item> lista2 = new ArrayList<>();
		lista2.add(it1r2);
		lista2.add(it2r2);
		lista2.add(it3r2);
		r2.setListaIngredientes(lista2);
		
		r2.setListaItemStringona(" ");
		
		r2.setModoPreparo("Junte Tudo e amasse até soltar das mãos (caso precise um pouquinho a mais de polvilho, coloque aos poucos até que chegue ao ponto de enrolar).\r\n"
				+ "Faça bolinhas, coloque em forma untada e asse em forno preaquecido bem quente.\r\n"
				+ "Se achar necessário, acrescente sal.\r\n"
				+ "Asse até ficarem douradinhos levemente.");
		r2.setDificuldade("Avançado");
		r2.setRendimento("5 pessoas");
		r2.setTempoPreparo("2h");
		receitaRepository.save(r2);
		
		//Receita 3
		Item it1r3 = new Item();
		it1r3.setQtdIngrediente("4");
		it1r3.setUnidadeMedida(und);
		it1r3.setIngrediente(cebola);
		itemRepository.save(it1r3);
		
		Item it2r3 = new Item();
		it2r3.setQtdIngrediente("1");
		it2r3.setUnidadeMedida(copo);
		it2r3.setIngrediente(leite);
		itemRepository.save(it2r3);

		Item it3r3 = new Item();
		it3r3.setQtdIngrediente("1");
		it3r3.setUnidadeMedida(copo);
		it3r3.setIngrediente(farinhaTrigo);
		itemRepository.save(it3r3);

		Item it4r3 = new Item();
		it4r3.setQtdIngrediente("1");
		it4r3.setUnidadeMedida(und);
		it4r3.setIngrediente(ovos);
		itemRepository.save(it4r3);

		Item it5r3 = new Item();
		it5r3.setQtdIngrediente("");		
		it5r3.setUnidadeMedida(agosto);
		it5r3.setIngrediente(oregano);		
		itemRepository.save(it5r3);
		
		Item it6r3 = new Item();
		it6r3.setQtdIngrediente("");		
		it6r3.setUnidadeMedida(agosto);
		it6r3.setIngrediente(sal);
		itemRepository.save(it6r3);
		
		Item it7r3 = new Item();
		it7r3.setQtdIngrediente("");		
		it7r3.setUnidadeMedida(agosto);
		it7r3.setIngrediente(agua);
		itemRepository.save(it7r3);
		
		Item it8r3 = new Item();
		it8r3.setQtdIngrediente("");		
		it8r3.setUnidadeMedida(qtbaste);
		it8r3.setIngrediente(oleo);
		itemRepository.save(it8r3);
				
		
		Receita r3 = new Receita();
		r3.setNomeReceita("Anéis de Cebola");
		
		List<Item> lista3 = new ArrayList<>();
		lista3.add(it1r3);
		lista3.add(it2r3);
		lista3.add(it3r3);
		lista3.add(it4r3);
		lista3.add(it5r3);
		lista3.add(it6r3);
		lista3.add(it7r3);
		lista3.add(it8r3);
		
		r3.setListaIngredientes(lista3);
		r3.setListaItemStringona(" ");
		
		r3.setModoPreparo("Corte as cebolas em rodelas bem finas.\r\n"
				+ "\r\n"
				+ "Separe os anéis e deixe de molho na água com um fio de óleo por uma hora, para tirar o gosto amargo da cebola.\r\n"
				+ "\r\n"
				+ "Bata o ovo, misture no leite e tempere com sal e orégano.\r\n"
				+ "\r\n"
				+ "Tempere também a farinha de trigo com sal e orégano.\r\n"
				+ "\r\n"
				+ "Passe as rodelas de cebola no leite temperado e depois na farinha.\r\n"
				+ "\r\n"
				+ "Frite em óleo quente sem sobrepô-las e escorra em papel absorvente.\r\n"
				+ "\r\n"
				+ "Fica crocante e maravilhosa.");
		r3.setDificuldade("Avançado");
		r3.setRendimento("4 pessoas");
		r3.setTempoPreparo("2h");
		receitaRepository.save(r3);
		
		Usuario us1 = new Usuario();
		us1.setEmail("admin@gft.com");
		us1.setSenha(passwordEncoder.encode("Gft@1234"));
		us1.setPrivilegio("admin");
		usuarioRepository.save(us1);

		Usuario us2 = new Usuario();
		us2.setEmail("usuario@gft.com");
		us2.setSenha(passwordEncoder.encode("Gft@1234"));
		us2.setPrivilegio("user");
		usuarioRepository.save(us2);
	}
	
	
	
	

}
