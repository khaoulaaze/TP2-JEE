package ma.khaoulaemsi.tp2jee;

import ma.khaoulaemsi.tp2jee.entities.product;
import ma.khaoulaemsi.tp2jee.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2JeeApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2JeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //L'ajout des produits
        productRepository.save(new product(null,"computer",4898.1,5));
        productRepository.save(new product(null,"iphone",5467.5,7));
        productRepository.save(new product(null,"ipad",4000.0,3));

        //lister tous les produits
        List<product> products = productRepository.findAll();
        products.forEach(p-> System.out.println(p.toString()));

        product product = productRepository.findById(Long.valueOf(1)).get();

        //mettre a jour un produit
        product.setQuantity(8);
        productRepository.save(product);

        //afficher un seul produit
        System.out.println("******************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());



        //supprimer un produit
        productRepository.deleteById(Long.valueOf(3 ));
    }
}
