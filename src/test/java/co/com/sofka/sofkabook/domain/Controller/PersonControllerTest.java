package co.com.sofka.sofkabook.domain.Controller;

import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPersonDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.IPostDataRepository;
import co.com.sofka.sofkabook.domain.Publicaciones.repository.PostData;
import co.com.sofka.sofkabook.useCases.TransformPersonUseCase;
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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPersonDataRepository data;

    @MockBean
    private TransformPersonUseCase transformacionUseCase;

    @Test
    @DisplayName("POST /apiUser Success")
    public void guardarTest() throws Exception {
        ///{IdUsuario}/{Email}/{Name}/{Fecha}
        String idUsuario = "1";
        String email = "s@gmail.com";
        String name = "sebas";
        String fecha = "12";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/apiUser/{IdUsuario}/{Email}/{Name}/{Fecha}", idUsuario, email, name, fecha)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("" +
                        "{\"idUsuario\":\"1\"," +
                        "\"email\":\"s@gmail.com\"," +
                        "\"name\":\"sebas\"," +
                        "\"fecha\":\"12}"));

    }


    }

