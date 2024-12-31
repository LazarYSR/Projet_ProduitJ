package ma.ehei.prj_prod.Service;


import ma.ehei.prj_prod.Dao.ProduitDao;
import ma.ehei.prj_prod.Models.Produit;
import ma.ehei.prj_prod.Service.impl.ProduitServiceimpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Permet d'utiliser Mockito avec JUnit 5
public class ProduitServiceTest {

    @Mock
    private ProduitDao produitDao; // Mock du DAO pour simuler les interactions avec la base de données

    @InjectMocks
    private ProduitServiceimpl produitService; // Injecte les mocks dans la classe de service

    @Test
    void ajouterProduit() {
        Produit produit = new Produit(1L, "Produit1", 100, 10);

        doNothing().when(produitDao).ajouter(produit); // Simule la méthode ajouter du DAO

        produitService.ajouterProduit(produit);

        verify(produitDao, times(1)).ajouter(produit); // Vérifie que la méthode a été appelée une fois
    }

    @Test
    void ramenerTousProduits() {
        Produit produit1 = new Produit(1L, "Produit1", 100, 10);
        Produit produit2 = new Produit(2L, "Produit2", 200, 20);

        when(produitDao.tousProduits()).thenReturn(Arrays.asList(produit1, produit2)); // Simule le retour d'une liste de produits

        List<Produit> produits = produitService.RamenerTousProduits();

        assertNotNull(produits);
        assertEquals(2, produits.size());
        assertEquals("Produit1", produits.get(0).getDesignation());
        assertEquals("Produit2", produits.get(1).getDesignation());

        verify(produitDao, times(1)).tousProduits(); // Vérifie que la méthode a été appelée une fois
    }

    @Test
    void chercherParDesignation() {
        String designation = "Produit1";
        Produit produit = new Produit(1L, "Produit1", 100, 10);

        when(produitDao.recupererPardesignation(designation)).thenReturn(produit); // Simule le retour d'un produit

        Produit result = produitService.chercherParDesignation(designation);

        assertNotNull(result);
        assertEquals(designation, result.getDesignation());

        verify(produitDao, times(1)).recupererPardesignation(designation); // Vérifie que la méthode a été appelée une fois
    }
}
