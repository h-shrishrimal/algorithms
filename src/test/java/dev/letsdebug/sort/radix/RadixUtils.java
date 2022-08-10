package dev.letsdebug.sort.radix;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.fail;

final class RadixUtils {

  static final void assertArrayNotEquals(String[] expected, String[] actual) {
    try {
      Assertions.assertArrayEquals(expected, actual);
    } catch (AssertionError e) {
      return;
    }
    fail("The arrays are equal");
  }

  static String[] VARIABLE_LENGTH_SORTED_DATA =
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

  static final String[] SORTED_DATA =
      new String[] {
        "able", "acid", "aged", "also", "area", "army", "away", "baby", "back", "ball", "band",
        "bank", "base", "bath", "bear", "beat", "been", "beer", "bell", "belt", "best", "bill",
        "bird", "blow", "blue", "boat", "body", "bomb", "bond", "bone", "book", "boom", "born",
        "boss", "both", "bowl", "bulk", "burn", "bush", "busy", "call", "calm", "came", "camp",
        "card", "care", "case", "cash", "cast", "cell", "chat", "chip", "city", "club", "coal",
        "coat", "code", "cold", "come", "cook", "cool", "cope", "copy", "core", "cost", "crew",
        "crop", "dark", "data", "date", "dawn", "days", "dead", "deal", "dean", "dear", "debt",
        "deep", "deny", "desk", "dial", "dick", "diet", "disc", "disk", "does", "done", "door",
        "dose", "down", "draw", "drew", "drop", "drug", "dual", "duke", "dust", "duty", "each",
        "earn", "ease", "east", "easy", "edge", "else", "even", "ever", "evil", "exit", "face",
        "fact", "fail", "fair", "fall", "farm", "fast", "fate", "fear", "feed", "feel", "feet",
        "fell", "felt", "file", "fill", "film", "find", "fine", "fire", "firm", "fish", "five",
        "flat", "flow", "food", "foot", "ford", "form", "fort", "four", "free", "from", "fuel",
        "full", "fund", "gain", "game", "gate", "gave", "gear", "gene", "gift", "girl", "give",
        "glad", "goal", "goes", "gold", "golf", "gone", "good", "gray", "grew", "grey", "grow",
        "gulf", "hair", "half", "hall", "hand", "hang", "hard", "harm", "hate", "have", "head",
        "hear", "heat", "held", "hell", "help", "here", "hero", "high", "hill", "hire", "hold",
        "hole", "holy", "home", "hope", "host", "hour", "huge", "hung", "hunt", "hurt", "idea",
        "inch", "into", "iron", "item", "jack", "jane", "jean", "john", "join", "jump", "jury",
        "just", "keen", "keep", "kent", "kept", "kick", "kill", "kind", "king", "knee", "knew",
        "know", "lack", "lady", "laid", "lake", "land", "lane", "last", "late", "lead", "left",
        "less", "life", "lift", "like", "line", "link", "list", "live", "load", "loan", "lock",
        "logo", "long", "look", "lord", "lose", "loss", "lost", "love", "luck", "made", "mail",
        "main", "make", "male", "many", "mark", "mass", "matt", "meal", "mean", "meat", "meet",
        "menu", "mere", "mike", "mile", "milk", "mill", "mind", "mine", "miss", "mode", "mood",
        "moon", "more", "most", "move", "much", "must", "name", "navy", "near", "neck", "need",
        "news", "next", "nice", "nick", "nine", "none", "nose", "note", "okay", "once", "only",
        "onto", "open", "oral", "over", "pace", "pack", "page", "paid", "pain", "pair", "palm",
        "park", "part", "pass", "past", "path", "peak", "pick", "pink", "pipe", "plan", "play",
        "plot", "plug", "plus", "poll", "pool", "poor", "port", "post", "pull", "pure", "push",
        "race", "rail", "rain", "rank", "rare", "rate", "read", "real", "rear", "rely", "rent",
        "rest", "rice", "rich", "ride", "ring", "rise", "risk", "road", "rock", "role", "roll",
        "roof", "room", "root", "rose", "rule", "rush", "ruth", "safe", "said", "sake", "sale",
        "salt", "same", "sand", "save", "seat", "seed", "seek", "seem", "seen", "self", "sell",
        "send", "sent", "sept", "ship", "shop", "shot", "show", "shut", "sick", "side", "sign",
        "site", "size", "skin", "slip", "slow", "snow", "soft", "soil", "sold", "sole", "some",
        "song", "soon", "sort", "soul", "spot", "star", "stay", "step", "stop", "such", "suit",
        "sure", "take", "tale", "talk", "tall", "tank", "tape", "task", "team", "tech", "tell",
        "tend", "term", "test", "text", "than", "that", "them", "then", "they", "thin", "this",
        "thus", "till", "time", "tiny", "told", "toll", "tone", "tony", "took", "tool", "tour",
        "town", "tree", "trip", "true", "tune", "turn", "twin", "type", "unit", "upon", "used",
        "user", "vary", "vast", "very", "vice", "view", "vote", "wage", "wait", "wake", "walk",
        "wall", "want", "ward", "warm", "wash", "wave", "ways", "weak", "wear", "week", "well",
        "went", "were", "west", "what", "when", "whom", "wide", "wife", "wild", "will", "wind",
        "wine", "wing", "wire", "wise", "wish", "with", "wood", "word", "wore", "work", "yard",
        "yeah", "year", "your", "zero", "zone"
      };
}
