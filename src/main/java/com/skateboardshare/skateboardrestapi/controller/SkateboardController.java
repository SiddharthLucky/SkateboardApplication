package com.skateboardshare.skateboardrestapi.controller;

import com.skateboardshare.skateboardrestapi.models.Skateboard;
import com.skateboardshare.skateboardrestapi.service.SkateboardJPAService_JPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class SkateboardController {

    private SkateboardJPAService_JPA skateboardJPAService_jpa;

    @Autowired
    public SkateboardController(SkateboardJPAService_JPA skateboardJPAService_jpa)
    {
        this.skateboardJPAService_jpa = skateboardJPAService_jpa;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }

    @GetMapping(path = "skateboards/{id}")
    public Optional<Skateboard> retrieveSkateboard(@PathVariable Integer id) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findBoard(id);

        log.info("SkateBoard is found with id: " + id);
        return skateboard;
    }

    @GetMapping(path = "skateboards")
    public List<Skateboard> retrieveAllSkateboards() {
        return skateboardJPAService_jpa.findAllBoards();
    }

    @GetMapping("skateboards/byLength/{length}")
    public Skateboard retrieveSkateBoardByLength(@PathVariable Integer length) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByBoardLength(length);


        log.info("Skateboard is found with length: " + length);
        return skateboard.get();
    }

    @GetMapping("skateboards/byWeight/{weight}")
    public Skateboard retrieveSkateboardByWeight(@PathVariable Integer weight) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByBoardWeight(weight);


        log.info("SkateBoard is found with weight: " + weight);
        return skateboard.get();
    }

    @GetMapping("skateboards/byBrand/{brand}")
    public Optional<Skateboard> retrieveSkateBoardByBrand(@PathVariable String brand) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByBoardBrand(brand);

        log.info("SkateBoard is found with brand: " + brand);
        return skateboard;
    }

    @GetMapping("skateboards/bylocation/{location}")
    public Optional<Skateboard> retrieveSkateBoardByLocation(@PathVariable String location) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByBoardLocation(location);

        log.info("SkateBoard is found with location: " + location);
        return skateboard;
    }

    @GetMapping("skateboards/owner/{ownerName}")
    public Skateboard retrieveSkateBoardByOwnersName(@PathVariable String ownerName) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByOwnersName(ownerName);

        log.info("SkateBoard is found under owners Name: " + ownerName);
        return skateboard.get();
    }

    @GetMapping("skateboards/borrower/{borrowersName}")
    public Optional<Skateboard> retrieveSkateBoardByBorrowersName(@PathVariable String borrowersName) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findByOwnersName(borrowersName);

        log.info("SkateBoard is found under Borrowers Name: " + borrowersName);
        return skateboard;
    }

    @DeleteMapping("skateboards/deleteBoard/{id}")
    public ResponseEntity<Object> deleteSkateBoard(@PathVariable Integer id) {
        Optional<Skateboard> skateBoard = skateboardJPAService_jpa.deleteSkateboardById(id);

        log.info("SkateBoard is deleted with id: " + id);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("skateboards/{id}/{ownerName}/{brand}/{length}/{weight}/{location}/{borrowersName}/{isAvailable}")
    public ResponseEntity<Skateboard> updateSkateBoard(@PathVariable(value = "id") Integer id,
                                                       @PathVariable(value = "ownerName") String ownerName,
                                                       @PathVariable(value = "brand") String brand,
                                                       @PathVariable(value = "length") Integer length,
                                                       @PathVariable(value = "weight") Integer weight,
                                                       @PathVariable(value = "location") String location,
                                                       @PathVariable(value = "borrowersName") String borrowersName,
                                                       @PathVariable(value = "isAvailable") Boolean isAvailable) {
        Optional<Skateboard> skateboard = skateboardJPAService_jpa.findBoard(id);

        if(skateboard.isPresent())
        {
            Skateboard skateboard_toUpdate = new Skateboard(id, ownerName, brand, length, weight, location, borrowersName, isAvailable);
            Optional<Skateboard> updateSkateBoard = skateboardJPAService_jpa.updateSkateboardDetails(skateboard_toUpdate);
            log.info("SkateBoard details updated for id: " + (skateboard.get()).getId());
            return ResponseEntity.ok(updateSkateBoard.get());
        }
        return null;
    }
}
