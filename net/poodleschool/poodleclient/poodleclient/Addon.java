/*     */ package net.poodleschool.poodleclient.poodleclient;
/*     */ import com.mojang.logging.LogUtils;
/*     */ import net.poodleschool.poodleclient.poodleclient.commands.ArmorCommand;
/*     */ import net.poodleschool.poodleclient.poodleclientcommands.MinefortJoin;
/*     */ import net.poodleschool.poodleclient.poodleclient.commands.SetSkinCommand;
/*     */ import net.poodleschool.poodleclient.poodleclient.screen.NavineTitleScreen;
/*     */ import net.poodleschool.poodleclient.poodleclient.screen.ProfilesWidget;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.GameDataUtil;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.RPCClient;
/*     */ import net.poodleschool.poodleclient.poodleclient.util.config.NavineConfig;
/*     */ import net.poodleschool.poodleclient.packets.CustomCommandPacket;
/*     */ import net.poodleschool.poodleclient.packets.MessagePacket;
/*     */ import eu.byncing.net.api.protocol.packet.EmptyPacket;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Predicate;
/*     */ import meteordevelopment.meteorclient.MeteorClient;
/*     */ import meteordevelopment.meteorclient.addons.MeteorAddon;
/*     */ import meteordevelopment.meteorclient.commands.Command;
/*     */ import meteordevelopment.meteorclient.commands.Commands;
/*     */ import meteordevelopment.meteorclient.events.game.SendMessageEvent;
/*     */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WContainer;
/*     */ import meteordevelopment.meteorclient.systems.hud.Hud;
/*     */ import meteordevelopment.meteorclient.systems.hud.HudGroup;
/*     */ import meteordevelopment.meteorclient.systems.modules.Category;
/*     */ import meteordevelopment.meteorclient.systems.modules.Module;
/*     */ import meteordevelopment.meteorclient.systems.modules.Modules;
/*     */ import meteordevelopment.meteorclient.utils.misc.MeteorStarscript;
/*     */ import meteordevelopment.orbit.EventHandler;
/*     */ import meteordevelopment.starscript.value.Value;
/*     */ import meteordevelopment.starscript.value.ValueMap;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.reflections.Reflections;
/*     */ import org.reflections.util.ConfigurationBuilder;
/*     */ import org.reflections.util.FilterBuilder;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ public class Addon extends MeteorAddon {
/*  42 */   public static final Logger LOG = LogUtils.getLogger();
/*  43 */   public static final Category CATEGORY = new Category("navine3", class_1802.field_8693.method_7854());
/*  44 */   public static final HudGroup HUD_GROUP = new HudGroup("navine3");
/*     */   
/*  46 */   public static final List<BiConsumer<GuiTheme, WContainer>> myWidgets = new ArrayList<>();
/*     */   
/*     */   public static Addon instance;
/*     */ 
/*     */   
/*     */   public void onInitialize() {
/*  52 */     LOG.info("Starting Poodle Client!");
/*  53 */     instance = this;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     Reflections moduleReflections = new Reflections((Configuration)(new ConfigurationBuilder()).forPackages(new String[] { "net.poodleschool.poodleclient.poodleclient.modules" }).filterInputsBy((Predicate)(new FilterBuilder()).includePackage("net.poodleschool.poodleclient.poodleclient.modules")));
/*     */     
/*  61 */     for (Class<? extends Module> clazz : (Iterable<Class<? extends Module>>)moduleReflections.getSubTypesOf(Module.class)) {
/*     */       try {
/*  63 */         Module m = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
/*  64 */         Modules.get().add(m);
/*  65 */       } catch (Exception e) {
/*  66 */         LOG.error("Couldn't register module", e);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  71 */     Commands.add((Command)new ArmorCommand());
/*  72 */     Commands.add((Command)new MinefortJoin());
/*  74 */     Commands.add((Command)new SetSkinCommand());
/*     */ 
/*     */     
/*  77 */     Hud.get().register(ActiveModulesHud.INFO);
/*  78 */     Hud.get().register(MiniTextHud.INFO);
/*     */ 
/*     */     
/*  81 */     MeteorStarscript.ss.set("navine", (new ValueMap())
/*  83 */         .set("packet_out", () -> Value.number(GameDataUtil.getPacketOutCount()))
/*  84 */         .set("packet_in", () -> Value.number(GameDataUtil.getPacketInCount()))
/*  85 */         .set("fps", () -> Value.number(GameDataUtil.getFPS())));
/*     */ 
/*     */ 
/*     */     
/*  89 */     MeteorClient.EVENT_BUS.subscribe(this);
/*  90 */     MeteorClient.EVENT_BUS.subscribe(new GameDataUtil());
/*     */ 
/*     */  }
/*     */ 
/*     */   
/*     */   public void onRegisterCategories() {
/* 123 */     Modules.registerCategory(CATEGORY);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPackage() {
/* 128 */     return "net.poodleschool.poodleclient.poodleclient";
/*     */   }
/*     */   
/*     */   static {
/* 132 */     myWidgets.add(ProfilesWidget::create);
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/Addon.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */