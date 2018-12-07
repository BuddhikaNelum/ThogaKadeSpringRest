package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.ItemDTO;
import lk.ijse.absd.pos.entity.Item;
import lk.ijse.absd.pos.repository.ItemRepository;
import lk.ijse.absd.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveItem(String code, ItemDTO itemDTO) {
        if (!code.equals(itemDTO.getCode())){
            throw new RuntimeException("Item id mismatched");
        }
        repository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQty()));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateItem(String code, ItemDTO itemDTO) {
        if(!code.equals(itemDTO.getCode())){
            throw new RuntimeException("Item id mismatched");
        }
        if (repository.existsById(code)){
            repository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQty()));
        }else {
            throw new RuntimeException("Item not found");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteItem(String code) {
        repository.deleteById(code);
    }

    @Override
    public ItemDTO findItem(String code) {
        Item item = repository.findById(code).get();
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQty());

    }

    @Override
    public List<ItemDTO> findAllItems() {
        List<Item> allItems = repository.findAll();
        List<ItemDTO> dtos = new ArrayList<>();
        allItems.forEach(item -> dtos.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQty())));
        return dtos;
    }

    @Override
    public long getItemCount() {
        return repository.count();
    }

    @Override
    public List<ItemDTO> findItemLike(String description) {
        List<Item> allItems = repository.findItemByDescriptionLike(description);
        List<ItemDTO> dtos = new ArrayList<>();
        allItems.forEach(item -> dtos.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQty())));
        return dtos;
    }

}
