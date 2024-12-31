package ma.ehei.prj_prod.Service;

import ma.ehei.prj_prod.Models.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProduitService {
    void ajouterProduit (Produit produit);
    List<Produit> RamenerTousProduits();
    Produit chercherParDesignation(String des);
}
