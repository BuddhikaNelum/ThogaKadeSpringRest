package lk.ijse.absd.pos.service;

import lk.ijse.absd.pos.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    void saveItem(String code, ItemDTO itemDTO);

    void updateItem(String code, ItemDTO itemDTO);

    void deleteItem(String code);

    ItemDTO findItem(String code);

    List<ItemDTO> findAllItems();

    long getItemCount();

    List<ItemDTO> findItemLike(String description);
}
