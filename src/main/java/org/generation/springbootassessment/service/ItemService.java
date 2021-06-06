package org.generation.springbootassessment.service;

import org.generation.springbootassessment.repository.Entity.Item;

import java.util.List;

public interface ItemService {

    Item save (Item item );

    void delete ( int itemId );

    List<Item> all();

    Item findById ( int itemId );
}
