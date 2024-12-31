package ma.ehei.prj_prod.Controller;

import ma.ehei.prj_prod.Models.Produit;
import ma.ehei.prj_prod.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> ProduitsTous() {
        List<Produit> produits = produitService.RamenerTousProduits();
        return ResponseEntity.ok(produits); // Encapsulation dans ResponseEntity
    }

    @PostMapping("/produit-aj")
    public ResponseEntity<Produit> Ajouter(@RequestBody Produit produit) {
        produitService.ajouterProduit(produit);
        return ResponseEntity.ok(produit); // Retourne l'objet ajouté avec un code HTTP 200
    }

    @GetMapping("/{des}")
    public ResponseEntity<Produit> GetProductByDesignation(@PathVariable String des) {
        Produit produit = produitService.chercherParDesignation(des);
        return ResponseEntity.ok(produit); // Encapsulation dans ResponseEntity
    }
}
