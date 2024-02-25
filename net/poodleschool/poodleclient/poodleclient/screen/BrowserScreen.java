/*     */ package net.poodleschool.poodleclient.poodleclient.screen;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonParser;
/*     */ import net.poodleschool.poodleclient.poodleclient.Addon;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import meteordevelopment.meteorclient.gui.GuiThemes;
/*     */ import meteordevelopment.meteorclient.gui.WindowScreen;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WItem;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WLabel;
/*     */ import meteordevelopment.meteorclient.gui.widgets.WWidget;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WSection;
/*     */ import meteordevelopment.meteorclient.gui.widgets.containers.WTable;
/*     */ import meteordevelopment.meteorclient.gui.widgets.input.WTextBox;
/*     */ import meteordevelopment.meteorclient.gui.widgets.pressable.WButton;
/*     */ import meteordevelopment.meteorclient.utils.Utils;
/*     */ import meteordevelopment.meteorclient.utils.network.Http;
/*     */ import meteordevelopment.meteorclient.utils.player.ChatUtils;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1802;
/*     */ import net.minecraft.class_1935;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_7923;
/*     */ 
/*     */ public class BrowserScreen extends WindowScreen {
/*  29 */   private JsonArray serversArray = null;
/*     */   
/*     */   private WTable t;
/*     */   private WLabel amount;
/*  33 */   private final AtomicBoolean computing = new AtomicBoolean(false);
/*     */   
/*     */   public BrowserScreen() {
/*  36 */     super(GuiThemes.get(), (WWidget)GuiThemes.get().item(new class_1799((class_1935)class_1802.field_8137)), "Server Browser");
/*     */   }
/*     */   private void loadServers(String filter) {
/*     */     JsonArray serversArray;
/*  40 */     this.computing.set(true);
/*  41 */     if (this.serversArray == null) {
/*  42 */       String str = Http.post("https://api.minefort.com/v1/servers/list").bodyJson("{\"pagination\": { \"skip\": 0, \"limit\": 500 }, \"sort\": { \"field\": \"players.online\", \"order\": \"desc\" }}").sendString();
/*  43 */       this.serversArray = JsonParser.parseString(str).getAsJsonObject().getAsJsonArray("result");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  48 */     if (filter != null) {
/*  49 */       Map<JsonElement, Integer> modules = new HashMap<>();
/*     */       
/*  51 */       for (JsonElement server : this.serversArray) {
/*  52 */         int score = Utils.searchLevenshteinDefault(server.getAsJsonObject().get("serverName").getAsString(), filter, false);
/*  53 */         modules.put(server, Integer.valueOf(((Integer)modules.getOrDefault(server, Integer.valueOf(0))).intValue() + score));
/*     */       } 
/*     */       
/*  56 */       serversArray = new JsonArray();
/*  57 */       Objects.requireNonNull(serversArray); modules.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).forEach(serversArray::add);
/*     */     } else {
/*  59 */       serversArray = this.serversArray;
/*     */     } 
/*     */     
/*  62 */     this.amount.set("Amount: " + serversArray.size());
/*     */     
/*  64 */     this.t.clear();
/*  65 */     for (JsonElement server : serversArray) {
/*     */       class_1792 item;
/*     */       try {
/*  68 */         String iconItem = server.getAsJsonObject().getAsJsonObject("serverIcon").get("item").getAsString();
/*  69 */         item = (class_1792)class_7923.field_41178.method_10223(class_2960.method_43902("minecraft", iconItem.toLowerCase()));
/*  70 */       } catch (Exception e) {
/*  71 */         Addon.LOG.error("Error!", e);
/*  72 */         item = class_1802.field_8077;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  79 */       String tooltip = "serverId: " + server.getAsJsonObject().get("serverId").getAsString() + " ; userId: " + server.getAsJsonObject().get("userId").getAsString() + " ; version: " + server.getAsJsonObject().get("version").getAsString() + " ; state: " + server.getAsJsonObject().get("state").getAsString() + " ; ";
/*     */       
/*  81 */       ((WItem)this.t.add((WWidget)this.theme.item(item.method_7854())).widget()).tooltip = tooltip;
/*     */       
/*  83 */       ((WLabel)this.t.add((WWidget)this.theme.label(server.getAsJsonObject().get("serverName").getAsString())).widget()).tooltip = translateAlternateColorCodes('&', server.getAsJsonObject().get("messageOfTheDay").getAsString());
/*     */       
/*  85 */       this.t.add((WWidget)this.theme.label("" + server
/*  86 */             .getAsJsonObject().getAsJsonObject("players").get("online").getAsInt() + "/" + server.getAsJsonObject().getAsJsonObject("players").get("online").getAsInt()));
/*     */ 
/*     */       
/*  89 */       WButton join = (WButton)this.t.add((WWidget)this.theme.button("Join")).widget();
/*  90 */       join.action = (() -> ChatUtils.sendPlayerMsg("/server " + server.getAsJsonObject().get("serverName").getAsString()));
/*     */ 
/*     */ 
/*     */       
/*  94 */       this.t.row();
/*     */     } 
/*  96 */     this.computing.set(false);
/*     */   }
/*     */   
/*     */   private static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
/* 100 */     char[] b = textToTranslate.toCharArray();
/* 101 */     for (int i = 0; i < b.length - 1; i++) {
/* 102 */       if (b[i] == altColorChar && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
/* 103 */         b[i] = '§';
/* 104 */         b[i + 1] = Character.toLowerCase(b[i + 1]);
/*     */       } 
/*     */     } 
/* 107 */     return new String(b);
/*     */   }
/*     */   
/*     */   private void parseDescription(WTable table, String description) {
/* 111 */     StringBuilder sb = new StringBuilder();
/* 112 */     for (char c : description.toCharArray()) {
/* 113 */       if (c != '\n') {
/* 114 */         sb.append(c);
/*     */       } else {
/* 116 */         table.add((WWidget)this.theme.label(sb.toString()));
/* 117 */         sb.setLength(0);
/* 118 */         table.row();
/*     */       } 
/*     */     } 
/* 121 */     table.add((WWidget)this.theme.label(sb.toString()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void initWidgets() {
/* 126 */     WTextBox search = (WTextBox)add((WWidget)this.theme.textBox("", "Enter search...")).expandX().widget();
/* 127 */     search.action = (() -> {
/*     */         if (!this.computing.get()) {
/*     */           try {
/*     */             loadServers(search.get());
/* 131 */           } catch (Exception e) {
/*     */             Addon.LOG.error("Couldn't compute search!", e);
/*     */           } 
/*     */         }
/*     */       });
/* 136 */     search.setFocused(true);
/*     */     
/* 138 */     this.amount = (WLabel)add((WWidget)this.theme.label("Loading...")).widget();
/* 139 */     WSection sect = (WSection)add((WWidget)this.theme.section("Servers", true)).widget();
/* 140 */     sect.add((WWidget)(this.t = this.theme.table()));
/*     */     try {
/* 142 */       loadServers((String)null);
/* 143 */     } catch (Exception e) {
/* 144 */       Addon.LOG.error("Couldn't load minefort server list!");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/screen/BrowserScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */