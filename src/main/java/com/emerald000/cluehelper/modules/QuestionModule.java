package com.emerald000.cluehelper.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QuestionModule implements ClueModule {
    private final int answer;
}
