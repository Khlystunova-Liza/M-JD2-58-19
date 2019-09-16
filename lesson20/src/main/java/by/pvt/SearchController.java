package by.pvt;

import by.pvt.pojo.ProductCatalogItem;
import by.pvt.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/search")
public class SearchController {

    private static Logger log = Logger.getLogger("SearchController");

    @Autowired
    ProductCatalogService productCatalogService;

    @GetMapping
    public String search(@RequestParam("search-str") String str, Model model) {
        List<ProductCatalogItem> items = productCatalogService.searchByProductName(str);
        model.addAttribute("result", items);
        log.info("searchResult "+ items);
        return "searchResult";
    }

}