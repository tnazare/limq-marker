package com.limq.model;

public enum PenaltyType {
    FAILURE_TO_COMPLY_TO_THE_CARD("Non-respect de la carte"),
    GAME_DELAY("Retard de jeu"),
    HAM_ACTING("Cabotinage"),
    ILLEGAL_PROCEDURE("Procédure illégale"),
    OTHER("To be added");

    private final String description;

    PenaltyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
