package com.example.lab5_Q3.Controller;

import com.example.lab5_Q3.ApiResponse.ApiResponse;
import com.example.lab5_Q3.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @PostMapping("/create")
    public ApiResponse createEvent(@RequestBody Event event){
        events.add(event);
        return new ApiResponse("Event added successfully");
    }

    @GetMapping("/display")
    public ArrayList<Event> displayEvent(){
        return events ;
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("Event removed successfully") ;
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index , @RequestBody Event event){
        events.set(index,event);
        return new ApiResponse("Event update successfully") ;
    }


    @PutMapping("/change/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index , @PathVariable int capacity){
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Capacity changed successfully") ;
    }

    @GetMapping("/search/{id}")
    public Event searchEventById(@PathVariable String id){
        for(Event event : events){
            if(event.getId().equals(id)){
                return event ;
            }
        }
        return null ;
    }








}
