package org.generation.springbootassessment.repository;

import org.generation.springbootassessment.repository.Entity.Item;
import org.springframework.data.repository.CrudRepository;
public interface ItemRepository extends CrudRepository<Item, Integer>{

}
