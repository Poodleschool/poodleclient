/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import java.util.Random;
/*     */ import meteordevelopment.meteorclient.settings.BoolSetting;
/*     */ import meteordevelopment.meteorclient.settings.EnumSetting;
/*     */ import meteordevelopment.meteorclient.settings.IntSetting;
/*     */ import meteordevelopment.meteorclient.settings.Setting;
/*     */ import net.minecraft.class_1268;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1802;
/*     */ import net.minecraft.class_1935;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2350;
/*     */ import net.minecraft.class_2374;
/*     */ import net.minecraft.class_2382;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_2489;
/*     */ import net.minecraft.class_2499;
/*     */ import net.minecraft.class_2520;
/*     */ import net.minecraft.class_3965;
/*     */ 
/*     */ public class NavineAirstrike extends Module {
/*  24 */   private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
/*     */   
/*     */   public enum Mode
/*     */   {
/*  28 */     Explosive,
/*  29 */     FurryStand;
/*     */   }
/*     */ 
/*     */   
/*  33 */   private final Setting<Mode> mode = this.sgGeneral.add((Setting)((EnumSetting.Builder)((EnumSetting.Builder)(new EnumSetting.Builder())
/*  34 */       .name("mode"))
/*  35 */       .defaultValue(Mode.Explosive))
/*  36 */       .build());
/*     */   
/*  38 */   private final Setting<Integer> radius = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  39 */       .name("radius"))
/*  40 */       .defaultValue(Integer.valueOf(30)))
/*  41 */       .sliderRange(1, 100)
/*  42 */       .build());
/*     */ 
/*     */   
/*  45 */   private final Setting<Integer> power = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  46 */       .name("power"))
/*  47 */       .defaultValue(Integer.valueOf(10)))
/*  48 */       .sliderRange(1, 127)
/*  49 */       .visible(() -> (this.mode.get() == Mode.Explosive)))
/*  50 */       .build());
/*     */ 
/*     */   
/*  53 */   private final Setting<Integer> height = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  54 */       .name("height"))
/*  55 */       .description("y level they spawn"))
/*  56 */       .defaultValue(Integer.valueOf(100)))
/*  57 */       .sliderRange(-63, 320)
/*  58 */       .build());
/*     */ 
/*     */   
/*  61 */   private final Setting<Integer> speed = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  62 */       .name("speed"))
/*  63 */       .defaultValue(Integer.valueOf(10)))
/*  64 */       .sliderRange(1, 10)
/*  65 */       .build());
/*     */ 
/*     */   
/*  68 */   private final Setting<Integer> delay = this.sgGeneral.add((Setting)((IntSetting.Builder)((IntSetting.Builder)((IntSetting.Builder)(new IntSetting.Builder())
/*  69 */       .name("delay"))
/*  70 */       .description("its in ticks"))
/*  71 */       .defaultValue(Integer.valueOf(2)))
/*  72 */       .sliderRange(0, 20)
/*  73 */       .build());
/*     */ 
/*     */   
/*  76 */   private final Setting<Boolean> standGlow = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  77 */       .name("glow"))
/*  78 */       .defaultValue(Boolean.valueOf(false)))
/*  79 */       .visible(() -> (this.mode.get() == Mode.FurryStand)))
/*  80 */       .build());
/*     */ 
/*     */   
/*  83 */   private final Setting<Boolean> standSmall = this.sgGeneral.add((Setting)((BoolSetting.Builder)((BoolSetting.Builder)((BoolSetting.Builder)(new BoolSetting.Builder())
/*  84 */       .name("small"))
/*  85 */       .defaultValue(Boolean.valueOf(true)))
/*  86 */       .visible(() -> (this.mode.get() == Mode.FurryStand)))
/*  87 */       .build()); class_243 origin;
/*     */   int i;
/*     */   
/*     */   public NavineAirstrike() {
/*  91 */     super(Addon.CATEGORY, "n-airstrike", "Annoy everyone with dumb air attacks");
/*     */ 
/*     */     
/*  94 */     this.origin = null;
/*  95 */     this.i = 0;
/*     */   }
/*     */   private class_243 pickRandomPos() {
/*  98 */     double x = (new Random()).nextDouble((((Integer)this.radius.get()).intValue() * 2)) - ((Integer)this.radius.get()).intValue() + this.origin.field_1352;
/*  99 */     double y = ((Integer)this.height.get()).intValue();
/* 100 */     double z = (new Random()).nextDouble((((Integer)this.radius.get()).intValue() * 2)) - ((Integer)this.radius.get()).intValue() + this.origin.field_1350;
/* 101 */     return new class_243(x, y, z);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onTick(TickEvent.Post event) {
/* 106 */     switch ((Mode)this.mode.get()) { case Explosive:
/* 107 */         modeExplosive(); break;
/* 108 */       case FurryStand: modeFurryStand();
/*     */         break; }
/*     */   
/*     */   }
/*     */   private void modeExplosive() {
/* 113 */     this.origin = this.mc.field_1724.method_19538();
/* 114 */     class_1799 bomb = new class_1799((class_1935)class_1802.field_8447);
/* 115 */     class_1799 bfr = this.mc.field_1724.method_6047();
/* 116 */     class_3965 bhr = new class_3965(this.mc.field_1724.method_19538(), class_2350.field_11033, new class_2338((class_2382)class_2338.method_49638((class_2374)this.mc.field_1724.method_19538())), false);
/* 117 */     this.i++;
/* 118 */     if ((this.mc.field_1724.method_31549()).field_7477) {
/* 119 */       if (this.i >= ((Integer)this.delay.get()).intValue()) {
/* 120 */         class_243 cpos = pickRandomPos();
/*     */         
/* 122 */         class_2487 tag = new class_2487();
/* 123 */         class_2499 speedlist = new class_2499();
/* 124 */         class_2499 pos = new class_2499();
/* 125 */         speedlist.add(class_2489.method_23241(0.0D));
/* 126 */         speedlist.add(class_2489.method_23241(-((Integer)this.speed.get()).intValue()));
/* 127 */         speedlist.add(class_2489.method_23241(0.0D));
/* 128 */         pos.add(class_2489.method_23241(cpos.field_1352));
/* 129 */         pos.add(class_2489.method_23241(((Integer)this.height.get()).intValue()));
/* 130 */         pos.add(class_2489.method_23241(cpos.field_1350));
/* 131 */         tag.method_10566("ExplosionPower", (class_2520)class_2489.method_23241(((Integer)this.power.get()).intValue()));
/* 132 */         tag.method_10566("power", (class_2520)speedlist);
/* 133 */         tag.method_10566("Pos", (class_2520)pos);
/* 134 */         tag.method_10582("id", "minecraft:fireball");
/* 135 */         bomb.method_7959("EntityTag", (class_2520)tag);
/* 136 */         this.mc.field_1761.method_2909(bomb, 36 + (this.mc.field_1724.method_31548()).field_7545);
/* 137 */         this.mc.field_1761.method_2896(this.mc.field_1724, class_1268.field_5808, bhr);
/* 138 */         this.mc.field_1761.method_2909(bfr, 36 + (this.mc.field_1724.method_31548()).field_7545);
/* 139 */         this.i = 0;
/*     */       } 
/*     */     } else {
/* 142 */       error("You need to be in creative mode.", new Object[0]);
/* 143 */       toggle();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void modeFurryStand() {
/* 148 */     this.origin = this.mc.field_1724.method_19538();
/* 149 */     class_1799 bomb = new class_1799((class_1935)class_1802.field_18005);
/* 150 */     class_1799 bfr = this.mc.field_1724.method_6047();
/* 151 */     class_3965 bhr = new class_3965(this.mc.field_1724.method_19538(), class_2350.field_11033, new class_2338((class_2382)class_2338.method_49638((class_2374)this.mc.field_1724.method_19538())), false);
/* 152 */     this.i++;
/* 153 */     if ((this.mc.field_1724.method_31549()).field_7477) {
/* 154 */       if (this.i >= ((Integer)this.delay.get()).intValue()) {
/*     */         class_2487 tag;
/*     */ 
/*     */         
/*     */         try {
/* 159 */           tag = class_2522.method_10718("{EntityTag:{id:\"minecraft:armor_stand\",CustomNameVisible:1b,Invulnerable:1b,Glowing:" + (((Boolean)this.standGlow.get()).booleanValue() ? 1 : 0) + "b,ShowArms:1b,Small:" + (((Boolean)this.standSmall.get()).booleanValue() ? 1 : 0) + "b,NoBasePlate:1b,HandItems:[{id:\"minecraft:wooden_sword\",Count:1b},{id:\"minecraft:shield\",Count:1b}],ArmorItems:[{id:\"minecraft:leather_boots\",Count:1b,tag:{display:{color:16747315}}},{id:\"minecraft:leather_leggings\",Count:1b,tag:{display:{color:16747315}}},{id:\"minecraft:leather_chestplate\",Count:1b,tag:{display:{color:16747315}}},{id:\"minecraft:player_head\",Count:1b,tag:{SkullOwner:{Id:[I;-74928838,-319076949,-1466972055,-1488595088],Properties:{textures:[{Value:\"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTJiZmNjZGZmOTU1NTZmM2Y1MTVlMTRhZTkyNTFjMjhjNjQ0M2VkOWFkNGRhYjRiNjJjY2ZhYjBkYWFkZDBiNiJ9fX0=\"}]}}}}],CustomName:'{\"text\":\"FurryHackers\",\"italic\":false}'}}");
/* 160 */         } catch (CommandSyntaxException e) {
/* 161 */           error(e.getMessage(), new Object[0]);
/*     */           
/*     */           return;
/*     */         } 
/* 165 */         class_243 cpos = pickRandomPos();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 176 */         class_2499 pos = new class_2499();
/* 177 */         pos.add(class_2489.method_23241(cpos.field_1352));
/* 178 */         pos.add(class_2489.method_23241(((Integer)this.height.get()).intValue()));
/* 179 */         pos.add(class_2489.method_23241(cpos.field_1350));
/* 180 */         tag.method_10562("EntityTag").method_10566("Pos", (class_2520)pos);
/* 181 */         bomb.method_7980(tag);
/*     */         
/* 183 */         this.mc.field_1761.method_2909(bomb, 36 + (this.mc.field_1724.method_31548()).field_7545);
/* 184 */         this.mc.field_1761.method_2896(this.mc.field_1724, class_1268.field_5808, bhr);
/* 185 */         this.mc.field_1761.method_2909(bfr, 36 + (this.mc.field_1724.method_31548()).field_7545);
/* 186 */         this.i = 0;
/*     */       } 
/*     */     } else {
/* 189 */       error("You need to be in creative mode.", new Object[0]);
/* 190 */       toggle();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/NavineAirstrike.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */