package crudrepository;

import model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
    Optional<Category> findAllById(int id);
}
