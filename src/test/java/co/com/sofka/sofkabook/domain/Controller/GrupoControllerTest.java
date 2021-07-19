package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.sofkabook.domain.Publicaciones.repository.IGrupoDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPersonDataRepository;
import co.com.sofka.sofkabook.useCases.TransformGrupoUseCase;
import co.com.sofka.sofkabook.useCases.TransformPersonUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class GrupoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGrupoDataRepository data;

    @MockBean
    private TransformGrupoUseCase transformacionUseCase;

    @Test
    @DisplayName("POST /apiGrupo Success")
    public void guardarTest() throws Exception {

        String idGrupo = "1";
        String titulo = "hola";
        String fecha = "12";
        String name = "sebas";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/apiGrupo/{IdGrupo}/{Titulo}/{Fecha}/{Name}", idGrupo, titulo, fecha, name)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("" +
                        "{\"idGrupo\":\"1\"," +
                        "\"titulo\":\"hola\"," +
                        "\"fecha\":\"12\"," +
                        "\"name\":\"sebas}"));
    }

}