package ma.ehei.prj_prod.Controller;

import ma.ehei.prj_prod.Models.Produit;
import ma.ehei.prj_prod.Service.ProduitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduitControllerTest {

    @Mock
    private ProduitService produitService;

    @InjectMocks
    private ProduitController produitController;

    @Test
    void produitsTous() {
        // Données simulées
        Produit produit1 = new Produit(1L, "Produit1", 100, 10);
        Produit produit2 = new Produit(2L, "Produit2", 200, 20);

        when(produitService.RamenerTousProduits()).thenReturn(Arrays.asList(produit1, produit2));

        ResponseEntity<List<Produit>> response = produitController.ProduitsTous();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("Produit1", response.getBody().get(0).getDesignation());

        verify(produitService, times(1)).RamenerTousProduits();
    }

    @Test
    void ajouter() {
        Produit produit = new Produit(1L, "Produit1", 100, 10);

        doNothing().when(produitService).ajouterProduit(produit);

        ResponseEntity<Produit> response = produitController.Ajouter(produit);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Produit1", response.getBody().getDesignation());

        verify(produitService, times(1)).ajouterProduit(produit);
    }

    @Test
    void getProductByDesignation() {
        String designation = "Produit1";
        Produit produit = new Produit(1L, "Produit1", 100, 10);

        when(produitService.chercherParDesignation(designation)).thenReturn(produit);

        ResponseEntity<Produit> response = produitController.GetProductByDesignation(designation);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Produit1", response.getBody().getDesignation());

        verify(produitService, times(1)).chercherParDesignation(designation);
    }
}
