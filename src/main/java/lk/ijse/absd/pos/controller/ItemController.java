package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PutMapping("/{code}")
    public void saveItem(@PathVariable("code") String code, @RequestBody ItemDTO itemDTO){
        itemService.saveItem(code,itemDTO);
    }

    @PostMapping("/{code}")
    public void updateItem(@PathVariable("code") String code,@RequestBody ItemDTO itemDTO){
        itemService.saveItem(code,itemDTO);
    }

    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable("code") String code){
        itemService.deleteItem(code);
    }

    @GetMapping("/{code}")
    public ItemDTO findItem(@PathVariable("code") String code){
        return itemService.findItem(code);
    }

    @GetMapping
    public Object findAllItems(@RequestParam(value = "action",required = false)String action,
                               @RequestParam(value = "description",required = false)String description){
        if (action != null){
            switch (action){
                case "count":
                    return itemService.getItemCount();
                case "like":
                    return itemService.findItemLike(description);
                default:
                    return itemService.findAllItems();
            }
        }else {
            return itemService.findAllItems();
        }
    }
}
