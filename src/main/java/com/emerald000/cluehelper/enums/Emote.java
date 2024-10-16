package com.emerald000.cluehelper.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.SpriteID;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.EnumMap;

@AllArgsConstructor
@Getter
public enum Emote {
    ANGRY("Angry", "/angry.png", SpriteID.EMOTE_ANGRY),
    BOW("Bow", "/bow.png", SpriteID.EMOTE_BOW),
    BULLROARER("Bullroarer", "/bullroarer.png", -1),
    CHEER("Cheer", "/cheer.png", SpriteID.EMOTE_CHEER),
    CLAP("Clap", "/clap.png", SpriteID.EMOTE_CLAP),
    CRY("Cry", "/cry.png", SpriteID.EMOTE_CRY),
    DANCE("Dance", "/dance.png", SpriteID.EMOTE_DANCE),
    HEADBANG("Headbang", "/headbang.png", SpriteID.EMOTE_HEADBANG),
    JIG("Jig", "/jig.png", SpriteID.EMOTE_JIG),
    JUMP_FOR_JOY("Jump for Joy", "/jump_for_joy.png", SpriteID.EMOTE_JUMP_FOR_JOY),
    LAUGH("Laugh", "/laugh.png", SpriteID.EMOTE_LAUGH),
    NO("No", "/no.png", SpriteID.EMOTE_NO),
    PANIC("Panic", "/panic.png", SpriteID.EMOTE_PANIC),
    RASPBERRY("Raspberry", "/raspberry.png", SpriteID.EMOTE_RASPBERRY),
    SHRUG("Shrug", "/shrug.png", SpriteID.EMOTE_SHRUG),
    SPIN("Spin", "/spin.png", SpriteID.EMOTE_SPIN),
    THINK("Think", "/think.png", SpriteID.EMOTE_THINK),
    WAVE("Wave", "/wave.png", SpriteID.EMOTE_WAVE),
    YAWN("Yawn", "/yawn.png", SpriteID.EMOTE_YAWN);

    private final String name;
    private final String file;
    private final int spriteId;

    @Getter
    private static final EnumMap<Emote, BufferedImage> singleImages = new EnumMap<>(Emote.class);

    public BufferedImage getImage() {
        BufferedImage image = singleImages.get(this);
        if (image == null) {
            image = ImageUtil.loadImageResource(Emote.class, file);
            singleImages.put(this, image);
        }
        return image;
    }
}