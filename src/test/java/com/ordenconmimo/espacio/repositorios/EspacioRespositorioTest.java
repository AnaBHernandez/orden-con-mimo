package com.ordenconmimo.espacio.repositorios;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.ordenconmimo.espacio.controladores.EspacioRestController;
import com.ordenconmimo.espacio.modelos.Espacio;
import com.ordenconmimo.espacio.servicios.EspacioService;
@WebMvcTest(EspacioRestController.class)
@AutoConfigureMockMvc(addFilters = false)
public class EspacioRespositorioTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean // Añadir esta anotación
    private EspacioService espacioService;
    private Espacio espacio1;
    private Espacio espacio2;
    @BeforeEach
    void setUp() {
        espacio1 = new Espacio("Espacio 1", "Descripción 1");
        espacio1.setId(1L);
        espacio2 = new Espacio("Espacio 2", "Descripción 2");
        espacio2.setId(2L);
        when(espacioService.obtenerTodosLosEspacios()).thenReturn(Arrays.asList(espacio1, espacio2));
        when(espacioService.obtenerEspacioPorId(1L)).thenReturn(Optional.of(espacio1));
        when(espacioService.obtenerEspacioPorId(999L)).thenReturn(Optional.empty());
        when(espacioService.guardarEspacio(any(Espacio.class))).thenAnswer(invocation -> {
            Espacio espacioToSave = invocation.getArgument(0);
            if (espacioToSave.getId() == null) {
                espacioToSave.setId(3L);
            }
            return espacioToSave;
        });
        when(espacioService.existeEspacio(1L)).thenReturn(true);
        when(espacioService.existeEspacio(999L)).thenReturn(false);
    }

    @Test
    public void documentarComportamientoActualAlEliminar() throws Exception {
        mockMvc.perform(delete("/api/espacios/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()); 
    }

    @Test
    public void deberiaObtenerEspacioPorId() throws Exception {
        mockMvc.perform(get("/api/espacios/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Espacio 1"));
    }

    @Test
    public void deberiaRetornarNotFoundCuandoEspacioNoExiste() throws Exception {
        mockMvc.perform(get("/api/espacios/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deberiaAceptarCreacionEspacioConJsonVacio() throws Exception {
        mockMvc.perform(post("/api/espacios")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated());
    }   
}