package com.cts.sql.daointerface;

import com.cts.sql.model.TeamClass;

public interface TeamManagement {
    void addTeam(TeamClass team) throws Exception;
    TeamClass viewTeam(int teamId) throws Exception;
    void viewAllTeam() throws Exception;
    void updateTeam(TeamClass team) throws Exception;
    void delTeam(int teamId) throws Exception;
}
