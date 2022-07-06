package com.intuitivecare.sikuli.util;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;

/**
 *
 * @author acardoso
 */
public class SikuliKeysMapping {

    public static final Map<String, String> SIKULI_KEYS_MAP =
            ImmutableMap.<String, String>builder()
            .put("CTRL", Key.CTRL)
            .put("ALT", Key.ALT)
            .put("TAB", Key.TAB)
            .put("ENTER", Key.ENTER)
            .put("DELETE", Key.DELETE)
            .put("UP", Key.UP)
            .put("LEFT", Key.LEFT)
            .put("RIGHT", Key.RIGHT)
            .put("END", Key.END)
            .put("DOWN", Key.DOWN)
            .put("F1", Key.F1)
            .put("F2", Key.F2)
            .put("F3", Key.F3)
            .put("F4", Key.F4)
            .put("F5", Key.F5)
            .put("F6", Key.F6)
            .put("F7", Key.F7)
            .put("F8", Key.F8)
            .put("F9", Key.F9)
            .put("F10", Key.F10)
            .put("F11", Key.F11)
            .put("F12", Key.F12)
            .put("ESC", Key.ESC)
            .build();

    public static final Map<String, Integer> SIKULI_KEYS_MODIFIER_MAP =
            ImmutableMap.<String, Integer>builder()
            .put("CTRL", KeyModifier.CTRL)
            .put("ALT", KeyModifier.ALT)
            .put("SHIFT", KeyModifier.SHIFT)
            .build();
}
