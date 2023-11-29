package sv.edu.ufg;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityWebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/index").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/secretaria/logeosecretaria").setViewName("views/home-secretaria");
        registry.addViewController("/secretaria/opciones").setViewName("views/secretarialist");
        registry.addViewController("/secretaria/buscaexpediente").setViewName("views/buscarexpediente");
        registry.addViewController("/secretaria/detalleexpediente/{idCompuesto}").setViewName("views/expedientelist");
        registry.addViewController("/views/expedientes/create").setViewName("views/frmcrearexpediente");
        registry.addViewController("/views/expedientes/edit/{idCompuesto}").setViewName("views/frmedicion");
        registry.addViewController("/diagnostico/veterinario").setViewName("views/consulta-veterinario");
        registry.addViewController("/diagnostico/iniciarconsulta").setViewName("views/iniciar-consulta");
        registry.addViewController("/diagnostico/crearconsulta/{idCompuesto}/{idcitas}").setViewName("views/creacion-consulta");
        registry.addViewController("/diagnostico/revisarConsulta").setViewName("views/revision-de-consulta");
        registry.addViewController("/views/citas/mostrarcita").setViewName("views/listadecitas");
        registry.addViewController("/views/citas/disponibles").setViewName("views/listadecitas");
        registry.addViewController("/views/citas/crearcita").setViewName("views/frmcitas");
        registry.addViewController("/views/citas/buscarcita").setViewName("views/buscacita");
        registry.addViewController("/views/citas/cita/{veterinario_asignado}/{idcitas}").setViewName("views/cancelacion");
        registry.addViewController("/views/citas/edit/{veterinario_asignado}/{idcitas}").setViewName("views/frmedicioncitas");
        

	}

}
