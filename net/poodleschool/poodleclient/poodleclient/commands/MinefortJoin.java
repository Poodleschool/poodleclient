/*     */ package de.Jakob.navine.commands;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.arguments.StringArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import de.Jakob.navine.Addon;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.regex.Pattern;
/*     */ import meteordevelopment.meteorclient.commands.Command;
/*     */ import meteordevelopment.meteorclient.utils.network.Http;
/*     */ import meteordevelopment.meteorclient.utils.player.ChatUtils;
/*     */ import net.minecraft.class_2172;
/*     */ import net.minecraft.class_2561;
/*     */ 
/*     */ public class MinefortJoin
/*     */   extends Command {
/*  27 */   private static final Pattern mcpePattern = Pattern.compile("00000000-0000-0000-....-............");
/*     */   
/*  29 */   private static final LinkedHashMap<String, String> nameCache = new LinkedHashMap<>();
/*     */   
/*     */   public MinefortJoin() {
/*  32 */     super("minefort", "Join another player on minefort", new String[] { "mf" });
/*     */   }
/*     */ 
/*     */   
/*     */   public void build(LiteralArgumentBuilder<class_2172> builder) {
/*  37 */     builder.then(literal("join").then(argument("player", (ArgumentType)StringArgumentType.string()).executes(context -> {
/*     */               String player = StringArgumentType.getString(context, "player");
/*     */ 
/*     */ 
/*     */               
/*     */               info("Searching...", new Object[0]);
/*     */ 
/*     */ 
/*     */               
/*     */               find(player).thenAccept(());
/*     */ 
/*     */ 
/*     */               
/*     */               return 1;
/*     */             })));
/*     */ 
/*     */     
/*  54 */     builder.then(literal("find").then(argument("player", (ArgumentType)StringArgumentType.string()).executes(context -> {
/*     */               String player = StringArgumentType.getString(context, "player");
/*     */ 
/*     */ 
/*     */               
/*     */               info("Searching...", new Object[0]);
/*     */ 
/*     */               
/*     */               find(player).thenAccept(());
/*     */ 
/*     */               
/*     */               return 1;
/*     */             })));
/*     */ 
/*     */     
/*  69 */     builder.then(literal("list").then(argument("server", (ArgumentType)StringArgumentType.string()).executes(context -> {
/*     */               String server = StringArgumentType.getString(context, "server");
/*     */               info("Searching...", new Object[0]);
/*     */               list(server).thenAccept(());
/*     */               return 1;
/*     */             })));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompletableFuture<String> find(String player) {
/*  85 */     return CompletableFuture.supplyAsync(() -> {
/*     */           try {
/*     */             String uuid = JsonParser.parseString(Http.get("https://playerdb.co/api/player/minecraft/" + player).sendString()).getAsJsonObject().getAsJsonObject("data").getAsJsonObject("player").get("id").getAsString();
/*     */ 
/*     */             
/*     */             String str = Http.post("https://api.minefort.com/v1/servers/list").bodyJson("{\"pagination\": { \"skip\": 0, \"limit\": 500 }, \"sort\": { \"field\": \"players.online\", \"order\": \"desc\" }}").sendString();
/*     */ 
/*     */             
/*     */             JsonArray obj = JsonParser.parseString(str).getAsJsonObject().get("result").getAsJsonArray();
/*     */             
/*     */             for (JsonElement jsonElement : obj) {
/*     */               for (JsonElement p : jsonElement.getAsJsonObject().getAsJsonObject("players").getAsJsonArray("list")) {
/*     */                 if (p.getAsJsonObject().get("uuid").getAsString().equalsIgnoreCase(uuid)) {
/*     */                   return jsonElement.getAsJsonObject().get("serverName").getAsString();
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/*     */             return null;
/* 104 */           } catch (Exception e) {
/*     */             error("Something went wrong! " + e.getMessage(), new Object[0]);
/*     */             return null;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public CompletableFuture<List<String>> list(String server) {
/* 112 */     return CompletableFuture.supplyAsync(() -> {
/*     */           try {
/*     */             List<String> result = new ArrayList<>();
/*     */             
/*     */             String str = Http.post("https://api.minefort.com/v1/servers/list").bodyJson("{\"pagination\": { \"skip\": 0, \"limit\": 500 }, \"sort\": { \"field\": \"players.online\", \"order\": \"desc\" }}").sendString();
/*     */             
/*     */             JsonArray obj = JsonParser.parseString(str).getAsJsonObject().get("result").getAsJsonArray();
/*     */             
/*     */             for (JsonElement jsonElement : obj) {
/*     */               if (jsonElement.getAsJsonObject().get("serverName").getAsString().equalsIgnoreCase(server)) {
/*     */                 for (JsonElement p : jsonElement.getAsJsonObject().getAsJsonObject("players").getAsJsonArray("list")) {
/*     */                   result.add(p.getAsJsonObject().get("uuid").getAsString());
/*     */                 }
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */             
/*     */             return result;
/* 131 */           } catch (Exception e) {
/*     */             Addon.LOG.error("Error!", e);
/*     */             error("Something went wrong! " + e.getMessage().substring(0, 50), new Object[0]);
/*     */             return null;
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public CompletableFuture<List<String>> uuidToName(List<String> uuids) {
/* 140 */     return CompletableFuture.supplyAsync(() -> {
/*     */           List<String> result = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           List<CompletableFuture<Void>> converters = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           for (String uuid : uuids) {
/*     */             Objects.requireNonNull(result);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             converters.add(CompletableFuture.supplyAsync(()).thenAccept(result::add));
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/*     */             CompletableFuture.allOf((CompletableFuture<?>[])converters.<CompletableFuture>toArray(new CompletableFuture[0])).get();
/* 174 */           } catch (InterruptedException|java.util.concurrent.ExecutionException e) {
/*     */             error("Something went wrong! " + e.getMessage(), new Object[0]);
/*     */           } 
/*     */           return result;
/*     */         });
/*     */   }
/*     */ }


/* Location:              /Users/iangoss/Downloads/navine-3.2.8.jar!/de/Jakob/navine/commands/MinefortJoin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */