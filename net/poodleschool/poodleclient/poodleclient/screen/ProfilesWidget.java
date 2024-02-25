/*    */ package net.poodleschool.poodleclient.poodleclient.screen;
/*    */ import java.util.Iterator;
/*    */ import java.util.Objects;
/*    */ import meteordevelopment.meteorclient.gui.GuiTheme;
/*    */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WContainer;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WTable;
/*    */ import meteordevelopment.meteorclient.gui.widgets.containers.WWindow;
/*    */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*    */ import meteordevelopment.meteorclient.gui.widgets.pressable.WMinus;
/*    */ import meteordevelopment.meteorclient.systems.profiles.Profile;
/*    */ import meteordevelopment.meteorclient.systems.profiles.Profiles;
/*    */ import net.minecraft.class_1802;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ public class ProfilesWidget {
/* 18 */   private static final Logger LOGGER = LogManager.getLogger("Crystal");
/*    */   
/*    */   public static void create(GuiTheme theme, WContainer container) {
/*    */     try {
/* 22 */       WWindow window = theme.window("profiles");
/* 23 */       window.id = "profiles";
/* 24 */       if (theme.categoryIcons()) {
/* 25 */         window.beforeHeaderInit = (wContainer -> wContainer.add((WWidget)theme.item(class_1802.field_8137.method_7854())).pad(2.0D));
/*    */       }
/* 27 */       container.add((WWidget)window);
/* 28 */       window.view.hasScrollBar = false;
/* 29 */       WTable profiles = (WTable)window.add((WWidget)theme.table()).widget();
/* 30 */       createProfiles(profiles, theme);
/*    */     }
/* 32 */     catch (Exception e) {
/* 33 */       LOGGER.error("An error occurred occurred during ProfilesWidget create:", e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String printif(String s, boolean b) {
/* 38 */     return b ? s : "";
/*    */   }
/*    */   
/*    */   protected static void createProfiles(WTable table, GuiTheme theme) {
/*    */     try {
/* 43 */       for (Iterator<Profile> iterator = Profiles.get().iterator(); iterator.hasNext(); ) { Profile profile = iterator.next();
/* 44 */         (table.add((WWidget)theme.label((String)profile.name.get())).expandCellX().widget()).tooltip = printif("hud ", ((Boolean)profile.hud.get()).booleanValue()) + printif("hud ", ((Boolean)profile.hud.get()).booleanValue()) + printif("macros ", ((Boolean)profile.macros.get()).booleanValue()) + printif("modules ", ((Boolean)profile.modules.get()).booleanValue());
/* 45 */         Objects.requireNonNull(profile); ((WButton)table.add((WWidget)theme.button("Save")).widget()).action = profile::save;
/* 46 */         Objects.requireNonNull(profile); ((WButton)table.add((WWidget)theme.button("Load")).widget()).action = profile::load;
/* 47 */         ((WMinus)table.add((WWidget)theme.minus()).widget()).action = (() -> {
/*    */             Profiles.get().remove(profile);
/*    */             table.clear();
/*    */             createProfiles(table, theme);
/*    */           });
/* 52 */         table.row(); }
/*    */ 
/*    */     
/* 55 */     } catch (Exception e) {
/* 56 */       LOGGER.error("An error occurred occurred while creating profiles in ProfilesWidget createProfiles:", e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/ProfilesWidget.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */