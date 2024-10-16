package com.emerald000.cluehelper.locations;

import java.util.List;

public interface NPCLocationInterface extends ClueLocation {
    List<Integer> getNpcIds();
    int getRadiusX();
    int getRadiusY();
}
