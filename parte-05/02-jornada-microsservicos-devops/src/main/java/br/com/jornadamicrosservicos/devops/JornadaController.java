package br.com.jornadamicrosservicos.devops;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JornadaController {

	private static final String modelo = "Bem-vindo à Jornada Microsserviços, %s!";
	private final AtomicLong contador = new AtomicLong();

	@GetMapping("/jornada")
	public Jornada jornada(@RequestParam(value = "nome", defaultValue = "Duke") String nome) {
		return new Jornada(contador.incrementAndGet(), String.format(modelo, nome));
	}
}
