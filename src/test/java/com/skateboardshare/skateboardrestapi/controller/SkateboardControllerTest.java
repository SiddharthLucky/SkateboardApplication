package com.skateboardshare.skateboardrestapi.controller;

import com.skateboardshare.skateboardrestapi.models.Skateboard;
import com.skateboardshare.skateboardrestapi.service.SkateboardJPAService_JPA;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
class SkateboardControllerTest
{
    @InjectMocks
    private SkateboardController skateboardController;

    @Mock
    private SkateboardJPAService_JPA skateboardJPAService_jpa;

    @Test
    void retrieveSkateboard()
    {
        //Arrange
        skateboardController = Mockito.mock(SkateboardController.class);
        Optional<Skateboard> expected_skateboard = Optional.of(new Skateboard(2, "OWNER2", "TEST2", 45, 30, "LOCATION2", null, false));
        Mockito.when(skateboardController.retrieveSkateboard(anyInt())).thenReturn(expected_skateboard);

        //Act
        Optional<Skateboard> actual_Skateboard = skateboardController.retrieveSkateboard(2);

        //Assert
        assertThat(actual_Skateboard).isEqualTo(expected_skateboard);
    }

    @Test
    void retrieveAllSkateboards()
    {

    }

    @Test
    void retrieveSkateBoardByLength()
    {

    }

    @Test
    void retrieveSkateboardByWeight()
    {

    }

    @Test
    void retrieveSkateBoardByBrand()
    {

    }

    @Test
    void retrieveSkateBoardByLocation()
    {

    }

    @Test
    void retrieveSkateBoardByOwnersName()
    {

    }

    @Test
    void retrieveSkateBoardByBorrowersName()
    {

    }

    @Test
    void deleteSkateBoard()
    {

    }

    @Test
    void updateSkateBoard()
    {

    }
}