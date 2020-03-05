package com.skateboardshare.skateboardrestapi.service;

import com.skateboardshare.skateboardrestapi.models.Skateboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateboardJPAServiceInterface extends CrudRepository<Skateboard, Integer>
{

}
