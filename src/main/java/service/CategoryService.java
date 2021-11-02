package service;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;

import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAll(){
        return categoryRepository.getAll();

    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);

        }else{
            Optional<Category> tnpCategory = categoryRepository.getCategory(category.getId());
            if(tnpCategory.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;

            }

        }

    }
    public Category update (Category category){
        if(category.getId()!=null) {
            Optional<Category> tmpCategory = categoryRepository.getCategory(category.getId());
            if (tmpCategory.isEmpty()) {
                return categoryRepository.save(category);
            }
        }
        return null;
    }
    public boolean deleteCategory(int id){
        Boolean aBoolean;
        aBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

