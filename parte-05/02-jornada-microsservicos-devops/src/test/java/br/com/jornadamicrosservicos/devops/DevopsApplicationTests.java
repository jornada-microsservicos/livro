package br.com.jornadamicrosservicos.devops;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DevopsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void jornadaSemParametroDeveRetornarMensagemPadrao() throws Exception {

		this.mockMvc.perform(get("/jornada")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.conteudo").value("Bem-vindo à Jornada Microsserviços, Duke!"));
	}

	@Test
	public void jornadaComParametroDeveRetornarMensagemPersonalizada() throws Exception {

		this.mockMvc.perform(get("/jornada").param("nome", "Javeiro"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.conteudo").value("Bem-vindo à Jornada Microsserviços, Javeiro!"));
	}

}
