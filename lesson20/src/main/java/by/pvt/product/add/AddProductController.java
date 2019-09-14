package by.pvt.product.add;

import by.pvt.pojo.ProductCatalogItem;
import by.pvt.service.ProductCatalogService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;


@Controller
@RequestMapping("/add-product")
public class AddProductController {

    @Autowired
    ProductCatalogService service;

   private static Logger Log = Logger.getLogger("AddProductController");
    @GetMapping
    public ModelAndView showAddProductView(){
  ModelAndView view = new ModelAndView();
  view.setViewName("addProduct");
  return view;
    }

    @PostMapping
    public String submitAddProductForm(
            @ModelAttribute ProductCatalogItem item,
            @RequestParam("file") MultipartFile file,
              BindingResult result) throws IOException {
    Log.info("Call submitAddProductForm" + item);
    Log.info("File: " + file);
    saveToFile(file);

        item.setProductImage(file.getBytes());

        if(!service.addItem(item) || result.hasErrors()){
        return "addProductError";
    }else
    return "addProductOk";
    }

    private boolean saveToFile(MultipartFile file) {
        if (!file.isEmpty()) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file.getName())) {
                byte[] bytes = file.getBytes();
                fileOutputStream.write(bytes);
            } catch (IOException e) {
                Log.severe(e.getMessage());
                return false;

            }
            return true;
        }else return false;
    }
}
