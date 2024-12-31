package ma.ehei.prj_prod.Dao.impl;

import ma.ehei.prj_prod.Dao.ProduitDao;
import ma.ehei.prj_prod.Dao.impl.Repository.ProduitRepository;
import ma.ehei.prj_prod.Models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProduitDaoimpl implements ProduitDao {
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public List<Produit> tousProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit recupererPardesignation(String des) {
        return produitRepository.findByDesignation(des);
    }

    @Override
    public void ajouter(Produit produit) {
        produitRepository.save(produit);
    }
}
