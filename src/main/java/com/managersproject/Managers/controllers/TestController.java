package com.managersproject.Managers.controllers;


import com.managersproject.Managers.models.Worker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(path = "worker")
public class TestController {

    static List<Worker> listWorker = new ArrayList<>();

    @GetMapping("/add")
    Worker addWorker(@RequestParam(name = "id") Long id, @RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
        Worker worker = Worker
                .builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
        listWorker.add(worker);
        printWorker();
        return worker;
    }

    @PostMapping("/show")
    List<Worker> showWorker(@RequestBody Worker worker) {
        return listWorker;
    }

    @GetMapping("/showme/{id}")
    Worker showFromIdWorker(@PathVariable(name = "id") Long id, @RequestParam(name = "id") int idNum) {
        return listWorker.get(idNum);
    }

    public static void printWorker() {
        for (Worker worker:TestController.listWorker) {
            System.out.println(worker.toString());
        }
    }
}
