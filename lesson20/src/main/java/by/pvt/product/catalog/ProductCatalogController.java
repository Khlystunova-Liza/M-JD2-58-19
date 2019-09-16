package by.pvt.product.catalog;

import by.pvt.pojo.ProductCatalogItem;
import by.pvt.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/product-catalog")
public class ProductCatalogController {

    private static Logger log = Logger.getLogger(ProductCatalogController.class.getName());

    @Autowired
   private ProductCatalogService productCatalogService;

    @GetMapping()
    public String showCatalog(Model model) {
        log.info("Calling showCatalog");
        model.addAttribute("catalog", productCatalogService.getFirstTopTenProducts());
        return "productCatalog";
    }



    @GetMapping("/item/{id}")
    public String showCatalogItem(@PathVariable Long id, Model model){
        log.info("Call showCatalogItem");
        ProductCatalogItem item = productCatalogService.findItem(id);
        model.addAttribute("item",item);
        return "productCatalogItem";

    }

    @GetMapping("/item/{id}/image")
    public @ResponseBody byte[] productItemImage(@PathVariable Long id) {
        return productCatalogService.findItem(id).getProductImage();
    }
}
