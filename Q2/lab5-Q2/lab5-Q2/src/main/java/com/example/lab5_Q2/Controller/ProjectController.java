package com.example.lab5_Q2.Controller;

import com.example.lab5_Q2.ApiResponse.ApiResponse;
import com.example.lab5_Q2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();


    @PostMapping("/create")
    public ApiResponse createProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("Project added successfully ! ") ;
    }

    @GetMapping("/display")
    public ArrayList<Project> displayProject(){
        return projects ;
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("Project removed successfully ! ")  ;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index , @RequestBody Project project){
        projects.set(index,project);
        return new ApiResponse("Project update successfully ! ") ;
    }

    @PutMapping("/change/{index}")
    public Project changeStatus(@PathVariable int index) {

        if(index < 0 || index >= projects.size()){
            return null;
        }

        Project project = projects.get(index);
        project.setStatus(!project.isStatus());

        return project ;
    }

    @GetMapping("/search/{title}")
    public Project searchForProjectByTitle(@PathVariable String title){
        for(Project project : projects){
            if(project.getTitle().equals(title)){
                return project ;
            }
        }
        return null ;
    }

    @GetMapping("/company-name/{name}")
    public ArrayList<Project> displayProjectByCompanyName(@PathVariable String name){
        ArrayList<Project> companyList = new ArrayList<>();
        for (Project project : projects){
            if(project.getCompanyName().equals(name)){
                companyList.add(project);
            }
        }
        return companyList;
    }







}
