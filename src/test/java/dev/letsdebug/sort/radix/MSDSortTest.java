package dev.letsdebug.sort.radix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/** Junit test for MSD Radix Sort */
public class MSDSortTest {

  String[] variableLengthSortedData =
      new String[] {
        "sab", "sac", "sack", "sad", "sae", "safe", "sag", "saga", "sage", "said", "sail", "saint",
        "sake", "sal", "salad", "sale", "sally", "salt", "same", "san", "sand", "sandy", "sang",
        "sank", "sap", "sat", "sau", "sauce", "save", "saw", "sax", "say", "saz", "sbe", "sbw",
        "scale", "scan", "scar", "scb", "scd", "scene", "sci", "scm", "scope", "score", "scot",
        "scr", "scrap", "sdk", "sea", "seal", "seat", "sec", "see", "seed", "seek", "seem", "seen",
        "seg", "sei", "sel", "self", "sell", "semi", "sen", "send", "sense", "sent", "sep", "sept",
        "ser", "serve", "set", "seven", "sew", "sex", "sexy", "sez", "sfz", "sgt", "sha", "shade",
        "shah", "shake", "shall", "shame", "shape", "share", "sharp", "she", "shed", "sheep",
        "sheer", "sheet", "shelf", "shell", "shh", "shift", "ship", "shirt", "shit", "sho", "shock",
        "shoe", "shook", "shoot", "shop", "shore", "short", "shot", "show", "shown", "shp", "sht",
        "shut", "shy", "sib", "sic", "sick", "side", "sif", "sigh", "sight", "sign", "sik", "silk",
        "silly", "sim", "sin", "since", "sing", "sink", "sip", "sir", "sis", "sit", "site", "siv",
        "six", "sixth", "sixty", "size", "sized", "ska", "ski", "skill", "skin", "skip", "sky",
        "slab", "slam", "slap", "sleep", "slid", "slide", "slim", "slip", "slot", "slow", "sly",
        "small", "smart", "smell", "smile", "smith", "smoke", "sms", "snap", "snow", "snr", "soap",
        "soar", "sob", "soc", "sod", "soda", "sofa", "soft", "soh", "soil", "sol", "solar", "sold",
        "sole", "solid", "solo", "solve", "som", "some", "son", "song", "soon", "sop", "sore",
        "sorry", "sort", "sos", "sot", "sou", "soul", "sound", "soup", "sour", "south", "sow",
        "sox", "soy", "soz", "spa", "space", "span", "spare", "speak", "speed", "spell", "spend",
        "spent", "spin", "spit", "split", "spoke", "sport", "spot", "spray", "spun", "spur", "spy",
        "squad", "sra", "srb", "sri", "srn", "ssd", "sta", "stack", "staff", "stage", "stake",
        "stamp", "stand", "star", "start", "state", "stay", "ste", "steam", "steel", "steep",
        "stem", "step", "stick", "stiff", "still", "stir", "stk", "stock", "stone", "stood", "stop",
        "store", "storm", "story", "strip", "stuck", "study", "stuff", "sty", "style", "sub",
        "such", "suck", "sud", "sue", "sugar", "sui", "suit", "suite", "suk", "sum", "sun", "sung",
        "sunk", "sup", "super", "suq", "sur", "sure", "surf", "surge", "sus", "swan", "swap",
        "sway", "sweep", "sweet", "swept", "swift", "swim", "swing", "syn"
      };

  /** Test for {@link MSDSort#sort(String[])} method. */
  @Test
  void msdSortTest() throws Exception {
    // copy the data
    String[] input = Arrays.copyOf(RadixUtils.SORTED_DATA, RadixUtils.SORTED_DATA.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, RadixUtils.SORTED_DATA);
    // method under test
    MSDSort.sort(input);
    Assertions.assertArrayEquals(input, RadixUtils.SORTED_DATA);
  }

  /** Test for {@link MSDSort#sort(String[])} method. */
  @Test
  void msdSortVariableLengthDataTest() throws Exception {
    // copy the data
    String[] input = Arrays.copyOf(variableLengthSortedData, variableLengthSortedData.length);
    // data is already sorted. so shuffle the entries.
    Collections.shuffle(Arrays.asList(input));
    // make sure input and data are different to start with
    RadixUtils.assertArrayNotEquals(input, variableLengthSortedData);
    // method under test
    MSDSort.sort(input);
    Assertions.assertArrayEquals(input, variableLengthSortedData);
  }
}
