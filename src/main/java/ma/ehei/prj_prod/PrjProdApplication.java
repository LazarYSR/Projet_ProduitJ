package ma.ehei.prj_prod;

import ma.ehei.prj_prod.Dao.impl.Repository.ProduitRepository;
import ma.ehei.prj_prod.Models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrjProdApplication  {
//    implements CommandLineRunner
    @Autowired
    private ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(PrjProdApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        produitRepository.save(new Produit(null, "Noga", 90.0f, 45));
//        produitRepository.save(new Produit(null, "Simon", 9.0f, 87));
//        produitRepository.save(new Produit(null, "OKI", 4.0f, 12));
//
//        List<Produit> Produits = produitRepository.findAll();
//        Produits.forEach(p->{
//            System.out.println(p.getId());
//            System.out.println(p.getPrix());
//            System.out.println(p.getDesignation());
//            System.out.println(p.getQuantite());
//        });
//    }
}
