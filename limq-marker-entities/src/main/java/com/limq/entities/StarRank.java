package com.limq.entities;

public enum StarRank {
    FIRST(1),
    SECOND(2),
    THIRD(3);
    private int rank;

    StarRank(int rank) {
        this.rank = rank;
    }
}
