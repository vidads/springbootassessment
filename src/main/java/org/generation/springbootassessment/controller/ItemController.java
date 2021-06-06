package org.generation.springbootassessment.controller;

import org.generation.springbootassessment.controller.dto.ItemDTO;
import org.generation.springbootassessment.repository.Entity.Item;
import org.generation.springbootassessment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

    @RestController
    @RequestMapping("/item")
    public class ItemController {
        final ItemService itemService;

        public ItemController( @Autowired ItemService itemService)
        {
            this.itemService = itemService;
        }
        @CrossOrigin
        @GetMapping( "/all" )
        public Iterable<Item> getItems()
        {
            return itemService.all();
        }

        //to avoid CORS
        //passing the ItemDTO class object into the save method
        //ItemDTO class object is the object that received the data passed from fetch.Ajax method in our frontend js
        //ItemDTO class object in turn, passed the data to Item class (Entity) to perform adding of record to the database
        //through the service layer

        @CrossOrigin
        @PostMapping( "/add" )
        public Item save(@RequestParam(name="title", required = true) String title,
                         @RequestParam(name="description", required = true) String description,
                         @RequestParam(name="date", required = true) String date) {

            Item itemDto = new Item(title, description, date);
            return itemService.save(itemDto);
        }

        @CrossOrigin
        @GetMapping( "/{id}" )
        public Item findItemById( @PathVariable Integer id )
        {
            return itemService.findById( id );
        }

        @CrossOrigin
        @PutMapping( "/{id}" )
        public Item update(@PathVariable Integer id, @RequestBody ItemDTO itemDto)

        {
            System.out.println("Hello");
            Item item = itemService.findById( id );
            item.setTitle( itemDto.getTitle() );
            item.setDescription( itemDto.getDescription() );
            item.setDate( itemDto.getDate() );
            return itemService.save( item );
        }

        @CrossOrigin
        @DeleteMapping( "/{id}" )
        public void delete( @PathVariable Integer id )
        {
            itemService.delete( id );
        }
}
