package com.example.TechnicalInterview.service;

import com.example.TechnicalInterview.entity.Team;
import com.example.TechnicalInterview.repository.ITeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MockitoExtension.class)
public class GetAllTeamsServiceTest {

    private ITeamRepository teamRepository;
    private GetAllTeamsService getAllTeamsService;

    @BeforeEach
    public void setUpServiceTest() {
        teamRepository = mock(ITeamRepository.class);
        getAllTeamsService = new GetAllTeamsService(teamRepository);
    }
    @Test
    void testGetAllTeams() {

        List<Team> exampleTeams = new ArrayList<>();
        exampleTeams.add(new Team(1L, "Barcelona",
                "Barcelona",
                "Lionel Messi",
                99000,
                1,
                "La Liga",
                25,
                null));

        exampleTeams.add(new Team(2L,
                "Real Madrid",
                "Madrid",
                "Sergio Ramos",
                84000,
                1,
                "La Liga",
                26,
                null));

        exampleTeams.add(new Team(3L,
                "Real Betis",
                "Sevilla",
                "Club members",
                60721,
                1,
                "La Liga",
                28,
                null));

        when(teamRepository.findAll()).thenReturn(exampleTeams);

        Team result = getAllTeamsService.getAll().get(0);

        verify(teamRepository, times(1)).findAll();

        assertEquals(exampleTeams.get(0), result);
    }
}
