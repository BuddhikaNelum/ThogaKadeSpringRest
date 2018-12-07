package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.Customer;
import lk.ijse.absd.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {

    List<Item> findItemByDescriptionLike(String description);


}
