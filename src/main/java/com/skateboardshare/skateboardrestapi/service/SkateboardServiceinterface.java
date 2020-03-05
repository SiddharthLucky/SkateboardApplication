package com.skateboardshare.skateboardrestapi.service;

import com.skateboardshare.skateboardrestapi.models.Skateboard;

import java.util.List;
import java.util.Optional;


public interface SkateboardServiceinterface
{
    Optional<Skateboard> saveBoard(Skateboard skateboard);

    Optional<Skateboard> findBoard(Integer id);

    List<Skateboard> findAllBoards();

    Optional<Skateboard> findByBoardLength(Integer length);

    Optional<Skateboard> findByBoardWeight(Integer weight);

    Optional<Skateboard> findByBoardBrand(String brand);

    Optional<Skateboard> findByBoardLocation(String location);

    Optional<Skateboard> findByBorrowersName(String borrowersName);

    Optional<Skateboard> findByOwnersName(String ownersName);

    Optional<Skateboard> deleteSkateboardById(Integer id);

    Optional<Skateboard> updateSkateboardDetails(Skateboard skateboard);
}
