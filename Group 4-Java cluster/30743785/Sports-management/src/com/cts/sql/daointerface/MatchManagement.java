package com.cts.sql.daointerface;

import com.cts.sql.model.MatchClass;

public interface MatchManagement {
	void addMatch(MatchClass match) throws Exception;
    MatchClass viewMatch(int matchId) throws Exception;
    void viewAllMatch() throws Exception;
    void updateMatch(MatchClass match) throws Exception;
    void updateMatchRecord(int matchId, String result) throws Exception;
    void delMatch(int del) throws Exception;
}
