package com.cts.sql.daointerface;

import com.cts.sql.model.PlayerClass;

public interface PlayerManagement {
	void addPlayer(PlayerClass player) throws Exception;
    PlayerClass viewPlayer(int playerId) throws Exception;
    void viewAllPlayer() throws Exception;
    void updatePlayer(PlayerClass player) throws Exception;
    void delPlayer(int playerId) throws Exception;
}
