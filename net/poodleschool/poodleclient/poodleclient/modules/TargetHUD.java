/*     */ package net.poodleschool.poodleclient.poodleclient.modules;
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import net.poodleschool.poodleclient.poodleclient.animation.Animation;
/*     */ import net.poodleschool.poodleclient.poodleclient.animation.Easing;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.Renderer;
/*     */ import java.awt.Color;
/*     */ import meteordevelopment.meteorclient.events.render.Render2DEvent;
/*     */ import meteordevelopment.meteorclient.renderer.text.TextRenderer;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*     */ import meteordevelopment.meteorclient.systems.modules.combat.KillAura;
/*     */ import meteordevelopment.meteorclient.systems.modules.world.Timer;
/*     */ import meteordevelopment.meteorclient.utils.Utils;
/*     */ import meteordevelopment.meteorclient.utils.render.NametagUtils;
/*     */ import meteordevelopment.meteorclient.utils.render.color.Color;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1309;
/*     */ import net.minecraft.class_243;
/*     */ import org.joml.Vector3d;
/*     */ 
/*     */ public class TargetHUD extends Module {
/*     */   private final Vector3d pos;
/*     */   private Animation blendInAnimation;
/*     */   
/*     */   public TargetHUD() {
/*  27 */     super(Addon.CATEGORY, "target-hud", "Shows information about your KillAura target");
/*     */ 
/*     */     
/*  30 */     this.pos = new Vector3d();
/*     */     
/*  32 */     this.blendInAnimation = new Animation(1000L, 0.0F, 2.0F, Easing.EASE_IN_BOUNCE);
/*     */     
/*  34 */     this.lastTarget = false;
/*     */   }
/*     */   private boolean lastTarget; private class_1309 living;
/*     */   @EventHandler
/*     */   public void onRender2D(Render2DEvent event) {
/*  39 */     class_1297 entity = ((KillAura)Modules.get().get(KillAura.class)).getTarget();
/*     */     
/*  41 */     if (this.living != null) {
/*  42 */       if (!this.living.method_5805()) {
/*  43 */         this.living = null;
/*     */         return;
/*     */       } 
/*  46 */       Utils.set(this.pos, (class_1297)this.living, event.tickDelta);
/*  47 */       this.pos.add(0.0D, this.living.method_17682(), 0.0D);
/*     */       
/*  49 */       if (!this.lastTarget && this.blendInAnimation.isDone()) {
/*  50 */         this.living = null;
/*     */         
/*     */         return;
/*     */       } 
/*  54 */       if (NametagUtils.to2D(this.pos, this.blendInAnimation.getValue())) {
/*  55 */         NametagUtils.begin(this.pos, event.drawContext);
/*  56 */         TextRenderer text = TextRenderer.get();
/*  57 */         text.beginBig();
/*     */         
/*  59 */         Renderer.R2D.renderRoundedQuadWithShadow(event.drawContext.method_51448(), new Color(10, 10, 20, 200), 0.0D, 0.0D, 200.0D, 100.0D, 5.0D, 20.0D);
/*  60 */         text.render(this.living.method_5477().getString(), 5.0D, 5.0D, Color.WHITE);
/*     */         
/*  62 */         float absorption = this.living.method_6067();
/*  63 */         int health = Math.round(this.living.method_6032() + absorption);
/*  64 */         float healthPercent = health / (this.living.method_6063() + absorption);
/*     */         try {
/*  66 */           Renderer.R2D.renderRoundedQuadWithShadow(event.drawContext.method_51448(), new Color(100, 100, 100, 255), 5.0D, 5.0D + text.getHeight() + 5.0D, 195.0D, 5.0D + text.getHeight() + 15.0D, 5.0D, 20.0D);
/*  67 */           Renderer.R2D.renderRoundedQuadWithShadow(event.drawContext.method_51448(), new Color(1.0F - healthPercent, healthPercent, 0.0F), 5.0D, 5.0D + text.getHeight() + 5.0D, (5.0F + 190.0F * healthPercent), 5.0D + text.getHeight() + 15.0D, 5.0D, 20.0D);
/*  68 */         } catch (Exception e) {
/*  69 */           text.render("render error :(", 5.0D, 5.0D + text.getHeight() + 5.0D, Color.WHITE);
/*     */         } 
/*     */         
/*  72 */         double dist = Math.round(PlayerUtils.distanceToCamera((class_1297)this.living) * 100.0D) / 100.0D;
/*  73 */         text.render("Distance: " + dist, 5.0D, 7.0D + text.getHeight() * 2.0D, Color.WHITE);
/*  74 */         text.render("Speed: " + Math.round(getEntitySpeed((class_1297)this.living).method_37267() * 100.0D) / 100.0D, 5.0D, 7.0D + text.getHeight() * 3.0D, Color.WHITE);
/*  75 */         text.render((Math.round(this.mc.field_1724.method_6032() + this.mc.field_1724.method_6067()) > health) ? "You are winning." : "You are loosing.", 5.0D, 7.0D + text.getHeight() * 4.0D, 
/*  76 */             (Math.round(this.mc.field_1724.method_6032() + this.mc.field_1724.method_6067()) > health) ? Color.GREEN : Color.RED);
/*     */         
/*  78 */         text.end();
/*  79 */         NametagUtils.end(event.drawContext);
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     if (!(entity instanceof class_1309)) {
/*  84 */       if (this.lastTarget) {
/*  85 */         this.blendInAnimation = new Animation(500L, 2.0F, 0.0F, Easing.EASE_IN_CUBIC);
/*     */       }
/*  87 */       this.lastTarget = false;
/*     */       
/*     */       return;
/*     */     } 
/*  91 */     if (!this.lastTarget) {
/*  92 */       this.blendInAnimation = new Animation(1000L, 0.0F, 2.0F, Easing.EASE_OUT_ELASTIC);
/*  93 */       this.lastTarget = true;
/*     */     } 
/*     */     
/*  96 */     this.living = (class_1309)entity;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class_243 getEntitySpeed(class_1297 ent) {
/* 102 */     if (ent == null) return class_243.field_1353;
/*     */     
/* 104 */     double tX = ent.method_23317() - ent.field_6014;
/* 105 */     double tY = ent.method_23318() - ent.field_6036;
/* 106 */     double tZ = ent.method_23321() - ent.field_5969;
/*     */     
/* 108 */     Timer timer = (Timer)Modules.get().get(Timer.class);
/* 109 */     if (timer.isActive()) {
/* 110 */       tX *= timer.getMultiplier();
/* 111 */       tY *= timer.getMultiplier();
/* 112 */       tZ *= timer.getMultiplier();
/*     */     } 
/*     */     
/* 115 */     tX *= 20.0D;
/* 116 */     tY *= 20.0D;
/* 117 */     tZ *= 20.0D;
/*     */     
/* 119 */     return new class_243(tX, tY, tZ);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/modules/TargetHUD.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */