package br.net.fabiozumbi12.RedProtect.Bukkit.jes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public final class JesHook {
    private static volatile Object api;

    private JesHook() {
    }

    private static Object api() {
        Object a = api;
        if (a != null) return a;
        synchronized (JesHook.class) {
            if (api != null) return api;
            try {
                Plugin jes = Bukkit.getPluginManager().getPlugin("JavaEconomyStats");
                if (jes != null) {
                    Class<?> c = jes.getClass().getClassLoader().loadClass("ru.minecraft.javaEconomyStats.api.PublicApi");
                    api = c.getMethod("get").invoke(null);
                }
            } catch (Throwable t) {
            }
            return api;
        }
    }

    public static void intent(UUID player, double amount, boolean deposit,
                              String type, String category, String reason, String meta) {
        Object a = api();
        if (a == null) return;
        try {
            a.getClass().getMethod("intentStr", String.class, UUID.class, double.class, boolean.class,
                    String.class, String.class, String.class, String.class, long.class)
              .invoke(a, "br.net.fabiozumbi12", player, amount, deposit, type, category, reason, meta, 3000L);
        } catch (Throwable ignored) {
        }
    }
}
