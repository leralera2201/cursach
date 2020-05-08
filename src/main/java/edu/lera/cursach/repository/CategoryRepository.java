package edu.lera.cursach.repository;

import edu.lera.cursach.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByCategoryName(String name);
}
