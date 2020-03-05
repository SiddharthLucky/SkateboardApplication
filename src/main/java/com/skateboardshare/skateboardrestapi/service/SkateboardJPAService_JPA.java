package com.skateboardshare.skateboardrestapi.service;

import com.skateboardshare.skateboardrestapi.models.Skateboard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SkateboardJPAService_JPA implements SkateboardServiceinterface {

    private SkateboardJPAServiceInterface skateboradrepo;

    @Autowired
    public SkateboardJPAService_JPA(SkateboardJPAServiceInterface skateboradrepo) {
        this.skateboradrepo = skateboradrepo;
    }

    @Transactional
    public List<Skateboard> findAllBoards() {
        log.info("Retrieved all Boards");
        return (List<Skateboard>) skateboradrepo.findAll();
    }

    @Transactional
    public Optional<Skateboard> findByBoardLength(Integer length) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getLength() == length)
            {
                log.info("Found Board with Length: "+skateBoard.getLength());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findByBoardWeight(Integer weight) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getWeight() == weight)
            {
                log.info("Found Board with Weight: "+skateBoard.getWeight());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findByBoardBrand(String brand) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getBrand().equals(brand))
            {
                log.info("Found Board with Board brand: "+skateBoard.getBrand());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findByBoardLocation(String location) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getLocation().equals(location))
            {
                log.info("Found Board with Boards Location: "+skateBoard.getLocation());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findByBorrowersName(String borrowersName) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getBorrowerName().equals(borrowersName))
            {
                log.info("Found Board with Board Borrowers Name: "+skateBoard.getBorrowerName());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findByOwnersName(String ownersName) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getOwnerName().equals(ownersName))
            {
                log.info("Found Board with Board owmers Name: "+skateBoard.getOwnerName());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> deleteSkateboardById(Integer id) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getId().equals(id))
            {
                log.info("Found Board with id: "+skateBoard.getId());
                skateboradrepo.delete(skateBoard);
                log.info("Deleted board with id: "+skateBoard.getId());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> updateSkateboardDetails(Skateboard skateboard) {
        for (Skateboard skateBoardLocal : skateboradrepo.findAll()) {
            if (skateBoardLocal.getId().equals(skateboard.getId()))
            {
                skateBoardLocal.setOwnerName(skateboard.getOwnerName());
                skateBoardLocal.setBoardAvailable(skateboard.isBoardAvailable());
                skateBoardLocal.setBorrowerName(skateboard.getBorrowerName());
                skateBoardLocal.setLength(skateboard.getLength());
                skateBoardLocal.setWeight(skateboard.getWeight());
                skateBoardLocal.setLocation(skateboard.getLocation());
                log.info("Found Board with Board brand: "+skateBoardLocal.getBrand());
                skateboradrepo.save(skateBoardLocal);
                return Optional.of(skateBoardLocal);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> findBoard(Integer integer) {
        for (Skateboard skateBoard : skateboradrepo.findAll()) {
            if (skateBoard.getId().equals(integer))
            {
                log.info("Found Board with Id: "+skateBoard.getId());
                return Optional.of(skateBoard);
            }
        }
        return null;
    }

    @Transactional
    public Optional<Skateboard> saveBoard(Skateboard skateboard)
    {
        skateboradrepo.save(skateboard);
        log.info("Saving board with Id: "+skateboard.getId());
        return Optional.of(skateboard);
    }
}
