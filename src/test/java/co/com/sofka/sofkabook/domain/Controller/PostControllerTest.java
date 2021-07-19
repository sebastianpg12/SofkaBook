package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import co.com.sofka.sofkabook.useCases.TransformPostUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPostDataRepository data;

    @MockBean
    private TransformPostUseCase transformacionUseCase;

    @Test
    @DisplayName("POST /api/guardar Success")

    public void guardarTest() throws Exception {
        String postId = "23";
        String idUsuario = "1234";
        String categoria = "qa";
        String descripcion = "hola";
        String titulo = "holaaa";
        String fecha = "1";
        String name = "sebas";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/guardar/{PostId}/{IdUsuario}/{Categoria}/{Descripcion}/{Titulo}/{Fecha}/{Name}", postId, idUsuario, categoria, descripcion,
                        titulo, fecha, name)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("" +
                        "{\"PostId\":\"23\"," +
                        "\"IdUsuario\":\"1234\"," +
                        "\"Categoria\":\"qa\"," +
                        "\"Descripcion\":\"hola\"," +
                        "\"Titulo\":\"holaaa\"," +
                        "\"Fecha\":\"1\"," +
                        "\"Name\":\"sebas}"));

    }

    @Test
    @DisplayName("GET /api/findPosts Success")
    public void listarId() throws Exception { new  PostData("23", "1234", "qa", "hola", "holaaa", "1", "sebas");

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/findPosts/{id}", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("23")))
                .andExpect(jsonPath("$.idUsuario", is("1234")));
    }


}