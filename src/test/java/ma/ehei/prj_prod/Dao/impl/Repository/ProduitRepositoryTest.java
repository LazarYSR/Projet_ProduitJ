package ma.ehei.prj_prod.Dao.impl.Repository;
import ma.ehei.prj_prod.Dao.impl.Repository.ProduitRepository;
import ma.ehei.prj_prod.Models.Produit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  // Use Mockito extension for mocking
class ProduitRepositoryTest {

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitRepositoryTest produitRepositoryTest;

    private Produit produit;

    @BeforeEach
    void setUp() {
        produit = new Produit();
        produit.setId(1L);
        produit.setDesignation("Produit1");
        produit.setPrix(100);
        produit.setQuantite(10);
    }

    @Test
    void shouldSaveAndRetrieveProduit() {
        // Mock the behavior of the repository save method
        when(produitRepository.save(produit)).thenReturn(produit);

        // Call the repository save method
        Produit savedProduit = produitRepository.save(produit);

        // Assert that the produit was saved correctly
        assertNotNull(savedProduit);
        assertEquals("Produit1", savedProduit.getDesignation());
        assertEquals(100.0, savedProduit.getPrix());
        assertEquals(10, savedProduit.getQuantite());

        // Verify that save method was called exactly once
        verify(produitRepository, times(1)).save(produit);

        // Mock the findAll method to return a list of produits
        when(produitRepository.findAll()).thenReturn(List.of(produit));

        // Retrieve the list of produits
        List<Produit> produits = produitRepository.findAll();

        // Assert that the retrieved produits list is correct
        assertEquals(1, produits.size());
        assertEquals("Produit1", produits.get(0).getDesignation());
    }

    @Test
    void shouldFindProduitByDesignation() {
        // Mock the behavior of the findByDesignation method
        when(produitRepository.findByDesignation("Produit1")).thenReturn(produit);

        // Call the repository findByDesignation method
        Produit retrievedProduit = produitRepository.findByDesignation("Produit1");

        // Assert that the produit was retrieved correctly
        assertNotNull(retrievedProduit);
        assertEquals("Produit1", retrievedProduit.getDesignation());

        // Verify that findByDesignation method was called exactly once
        verify(produitRepository, times(1)).findByDesignation("Produit1");
    }
}
