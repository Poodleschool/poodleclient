/*     */ package net.poodleschool.poodleclient.poodleclient.util;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class UwUSource {
/*     */   private final int stutterChance;
/*  12 */   private final Map<String, String> words = new HashMap<>(); private final int emojiChance;
/*  13 */   private final List<String> emojis = new ArrayList<>();
/*  14 */   private final List<Character> punctuation = Arrays.asList(new Character[] { Character.valueOf(','), Character.valueOf('.'), Character.valueOf('!'), Character.valueOf('?') });
/*     */   
/*     */   public UwUSource(int stutterChance, int emojiChance) {
/*  17 */     this.stutterChance = stutterChance;
/*  18 */     this.emojiChance = emojiChance;
/*     */     
/*  20 */     this.words.put("small", "smol");
/*  21 */     this.words.put("cute", "kawaii~");
/*  22 */     this.words.put("fluff", "floof");
/*  23 */     this.words.put("love", "luv");
/*  24 */     this.words.put("stupid", "baka");
/*  25 */     this.words.put("what", "nani");
/*  26 */     this.words.put("meow", "nya~");
/*     */     
/*  28 */     this.emojis.add(" rawr x3");
/*  29 */     this.emojis.add(" OwO");
/*  30 */     this.emojis.add(" UwU");
/*  31 */     this.emojis.add(" >w<");
/*  32 */     this.emojis.add(" (⑅˘꒳˘)");
/*  33 */     this.emojis.add(" (ꈍᴗꈍ)");
/*  34 */     this.emojis.add(" (˘ω˘)");
/*  35 */     this.emojis.add(" σωσ");
/*  36 */     this.emojis.add(" òωó");
/*  37 */     this.emojis.add(" (U ﹏ U)");
/*  38 */     this.emojis.add(" ʘwʘ");
/*  39 */     this.emojis.add(" :3");
/*  40 */     this.emojis.add(" XD");
/*  41 */     this.emojis.add(" nyaa~~");
/*  42 */     this.emojis.add(" mya");
/*  43 */     this.emojis.add(" >_<");
/*  44 */     this.emojis.add(" rawr");
/*  45 */     this.emojis.add(" ^^");
/*  46 */     this.emojis.add(" (^•ω•^)");
/*  47 */     this.emojis.add(" (✿oωo)");
/*  48 */     this.emojis.add("^w^");
/*     */   }
/*     */   
/*     */   public String uwuify(String input) {
/*  52 */     String output = input;
/*     */ 
/*     */     
/*  55 */     Pattern pattern = Pattern.compile(String.join("|", this.words.keySet()), 2);
/*  56 */     Matcher matcher = pattern.matcher(output);
/*  57 */     while (matcher.find()) {
/*  58 */       String word = matcher.group().toLowerCase(Locale.getDefault());
/*  59 */       String replace = this.words.get(word);
/*     */       
/*  61 */       boolean isAllCaps = word.equals(word.toUpperCase(Locale.getDefault()));
/*  62 */       if (isAllCaps) {
/*  63 */         replace = replace.toUpperCase(Locale.getDefault());
/*  64 */       } else if (Character.isUpperCase(word.charAt(0))) {
/*  65 */         replace = replace.substring(0, 1).toUpperCase(Locale.getDefault()) + replace.substring(0, 1).toUpperCase(Locale.getDefault());
/*     */       } 
/*     */       
/*  68 */       output = output.replaceAll("\\b" + Pattern.quote(matcher.group()) + "\\b", replace);
/*     */     } 
/*     */ 
/*     */     
/*  72 */     output = output.replace("na", "nya").replace("Na", "Nya").replace("nA", "nyA").replace("NA", "NYA");
/*     */ 
/*     */     
/*  75 */     output = output.replace('l', 'w').replace('r', 'w').replace('L', 'W').replace('R', 'W');
/*     */ 
/*     */     
/*  78 */     int offset = 0;
/*  79 */     String[] words = output.split(" ");
/*  80 */     for (String s : words) {
/*  81 */       if (s.length() > 1 && randomWithChance(this.stutterChance)) {
/*  82 */         output = prefixWord(output, s, "" + s.charAt(0) + "-", offset);
/*     */       }
/*  84 */       offset += s.length() + 1;
/*     */     } 
/*     */ 
/*     */     
/*  88 */     if (!this.punctuation.contains(Character.valueOf(output.charAt(output.length() - 1))) && randomWithChance(this.emojiChance)) {
/*  89 */       output = output + output;
/*     */     }
/*     */ 
/*     */     
/*  93 */     char[] array = output.toCharArray();
/*  94 */     for (int i = 0; i < array.length; i++) {
/*  95 */       char ch = array[i];
/*  96 */       if (this.punctuation.contains(Character.valueOf(ch)) && (i == array.length - 1 || array[i + 1] == ' ') && randomWithChance(this.emojiChance)) {
/*  97 */         output = suffixChar(output, ch, this.emojis.get((new Random()).nextInt(this.emojis.size() - 1)), i);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return output;
/*     */   }
/*     */   
/*     */   private String prefixWord(String input, String word, String prefix, int startIndex) {
/* 105 */     int index = input.indexOf(word, startIndex);
/* 106 */     return input.substring(0, index) + input.substring(0, index) + prefix;
/*     */   }
/*     */   
/*     */   private String suffixChar(String input, char ch, String suffix, int startIndex) {
/* 110 */     return input.substring(0, startIndex + 1) + input.substring(0, startIndex + 1) + suffix;
/*     */   }
/*     */   
/*     */   private boolean randomWithChance(int chance) {
/* 114 */     return ((new Random()).nextInt(101) <= chance);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/UwUSource.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */