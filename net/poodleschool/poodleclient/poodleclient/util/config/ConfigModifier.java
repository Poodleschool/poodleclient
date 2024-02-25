/*    */ package net.poodleschool.poodleclient.poodleclient.util.config;
/*    */ 
/*    */ import meteordevelopment.meteorclient.settings.DoubleSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.settings.StringSetting;
/*    */ import meteordevelopment.meteorclient.systems.config.Config;
/*    */ 
/*    */ public class ConfigModifier
/*    */ {
/*    */   private static ConfigModifier INSTANCE;
/*    */   public final SettingGroup sgNavine;
/*    */   public final Setting<String> rpcPrefix;
/*    */   public final Setting<Double> blurStrength;
/*    */   public final Setting<Double> menuButtonPosition;
/*    */   
/*    */   public ConfigModifier() {
/* 18 */     this.sgNavine = (Config.get()).settings.createGroup("Navine");
/*    */     
/* 20 */     this.rpcPrefix = this.sgNavine.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder())
/* 21 */         .name("rpc-prefix"))
/* 22 */         .description("Set the RPC prefix."))
/* 23 */         .defaultValue((NavineConfig.get()).rpcPrefix))
/* 24 */         .onChanged(v -> (NavineConfig.get()).rpcPrefix = v))
/* 25 */         .build());
/*    */ 
/*    */     
/* 28 */     this.blurStrength = this.sgNavine.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 29 */         .name("blur-strength"))
/* 30 */         .description("Set the Main Menu blur strength."))
/* 31 */         .defaultValue((NavineConfig.get()).blurStrength)
/* 32 */         .onChanged(v -> (NavineConfig.get()).blurStrength = v.floatValue()))
/* 33 */         .range(0.0D, 10.0D)
/* 34 */         .sliderRange(0.0D, 10.0D)
/* 35 */         .build());
/*    */ 
/*    */     
/* 38 */     this.menuButtonPosition = this.sgNavine.add((Setting)((DoubleSetting.Builder)((DoubleSetting.Builder)((DoubleSetting.Builder)(new DoubleSetting.Builder())
/* 39 */         .name("menu-button-position"))
/* 40 */         .description("Set the Main Menu button position."))
/* 41 */         .defaultValue((NavineConfig.get()).menuButtonPosition)
/* 42 */         .onChanged(v -> (NavineConfig.get()).menuButtonPosition = v.floatValue()))
/* 43 */         .range(2.0D, 95.0D)
/* 44 */         .sliderRange(2.0D, 95.0D)
/* 45 */         .build());
/*    */   }
/*    */   
/*    */   public static ConfigModifier get() {
/*    */     if (INSTANCE == null)
/*    */       INSTANCE = new ConfigModifier(); 
/*    */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/util/config/ConfigModifier.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */