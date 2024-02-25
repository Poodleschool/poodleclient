/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ 
/*     */ import com.mojang.blaze3d.systems.RenderSystem;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.BiConsumer;
/*     */ import meteordevelopment.meteorclient.MeteorClient;
/*     */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*     */ import meteordevelopment.meteorclient.gui.GuiThemes;
/*     */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WVerticalList;
/*     */ import meteordevelopment.meteorclient.gui.widgets.input.WTextBox;
/*     */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*     */ import meteordevelopment.meteorclient.systems.config.Config;
/*     */ import net.minecraft.class_437;
/*     */ 
/*     */ 
/*     */ public class LoginPrompt
/*     */ {
/*     */   private final GuiTheme theme;
/*     */   private final class_437 parent;
/*  23 */   private String title = "";
/*  24 */   private final List<String> messages = new ArrayList<>();
/*  25 */   private String id = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private LoginPrompt() {
/*  30 */     this(GuiThemes.get(), MeteorClient.mc.field_1755);
/*     */   } private BiConsumer<String, Boolean> onSubmit = (user, free) -> {
/*     */     
/*     */     }; private LoginPrompt(GuiTheme theme, class_437 parent) {
/*  34 */     this.theme = theme;
/*  35 */     this.parent = parent;
/*     */   }
/*     */   
/*     */   public static LoginPrompt create() {
/*  39 */     return new LoginPrompt();
/*     */   }
/*     */   
/*     */   public static LoginPrompt create(GuiTheme theme, class_437 parent) {
/*  43 */     return new LoginPrompt(theme, parent);
/*     */   }
/*     */   
/*     */   public LoginPrompt title(String title) {
/*  47 */     this.title = title;
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public LoginPrompt message(String message) {
/*  52 */     this.messages.add(message);
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public LoginPrompt message(String message, Object... args) {
/*  57 */     this.messages.add(String.format(message, args));
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public LoginPrompt id(String from) {
/*  62 */     this.id = from;
/*  63 */     return this;
/*     */   }
/*     */   
/*     */   public LoginPrompt onSubmit(BiConsumer<String, Boolean> action) {
/*  67 */     this.onSubmit = action;
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   public void show() {
/*  72 */     if (this.id == null) id(this.title); 
/*  73 */     if ((Config.get()).dontShowAgainPrompts.contains(this.id))
/*     */       return; 
/*  75 */     if (!RenderSystem.isOnRenderThread()) {
/*  76 */       RenderSystem.recordRenderCall(() -> MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme)));
/*     */     } else {
/*     */       
/*  79 */       MeteorClient.mc.method_1507((class_437)new PromptScreen(this.theme));
/*     */     } 
/*     */   }
/*     */   
/*     */   private class PromptScreen extends WindowScreen {
/*     */     public PromptScreen(GuiTheme theme) {
/*  85 */       super(theme, LoginPrompt.this.title);
/*     */       
/*  87 */       this.parent = LoginPrompt.this.parent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initWidgets() {
/*  92 */       for (String line : LoginPrompt.this.messages) add((WWidget)this.theme.label(line)).expandX(); 
/*  93 */       add((WWidget)this.theme.horizontalSeparator()).minWidth(200.0D).expandX();
/*     */       
/*  95 */       WVerticalList list = (WVerticalList)add((WWidget)this.theme.verticalList()).expandX().widget();
/*     */       
/*  97 */       WTextBox textBox = (WTextBox)list.add((WWidget)this.theme.textBox("", "Enter username", (text, c) -> (Character.isLetterOrDigit(c) || c == '_'))).expandX().widget();
/*  98 */       WButton submitButton = (WButton)list.add((WWidget)this.theme.button("Submit")).expandX().widget();
/*  99 */       WButton withoutButton = (WButton)list.add((WWidget)this.theme.button("Continue without login")).expandX().widget();
/*     */       
/* 101 */       submitButton.action = (() -> {
/*     */           LoginPrompt.this.onSubmit.accept(textBox.get(), Boolean.valueOf(false));
/*     */           
/*     */           method_25419();
/*     */         });
/* 106 */       withoutButton.action = (() -> {
/*     */           LoginPrompt.this.onSubmit.accept("free", Boolean.valueOf(true));
/*     */           method_25419();
/*     */         });
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/LoginPrompt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */