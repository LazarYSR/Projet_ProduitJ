package ma.ehei.prj_prod.Dao;

import ma.ehei.prj_prod.Models.Produit;

import java.util.List;

public interface ProduitDao {
    List<Produit> tousProduits ();
    Produit recupererPardesignation(String des);
    void ajouter(Produit produit);

}
