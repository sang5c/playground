package com.example.playground.team.ui;

import com.example.playground.team.application.TeamService;
import com.example.playground.team.ui.request.TeamRegisterRequest;
import com.example.playground.team.ui.response.TeamResponse;
import com.example.playground.team.ui.response.TeamsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/teams")
    public TeamsResponse showAllTeams() {
        return teamService.showAllTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamResponse showTeam(@PathVariable Long id) {
        return teamService.showTeam(id);
    }

    @PostMapping("/teams")
    public TeamResponse registerTeam(@RequestBody TeamRegisterRequest request) {
        return teamService.registerTeam(request);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deactivateTeam(id);
    }
}
