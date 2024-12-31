package ma.ehei.prj_prod.Dao.impl.Repository;

import ma.ehei.prj_prod.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Produit findByDesignation(String des);
}
