package ma.ehei.prj_prod.Service.impl;

import ma.ehei.prj_prod.Dao.ProduitDao;
import ma.ehei.prj_prod.Models.Produit;
import ma.ehei.prj_prod.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceimpl implements ProduitService{
    @Autowired
    private ProduitDao produitDao;

    @Override
    public void ajouterProduit(Produit produit) {
        produitDao.ajouter(produit);
    }

    @Override
    public List<Produit> RamenerTousProduits() {
        return produitDao.tousProduits();
    }

    @Override
    public Produit chercherParDesignation(String des) {
        return produitDao.recupererPardesignation(des);
    }
}
