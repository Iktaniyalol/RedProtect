package br.net.fabiozumbi12.RedProtect.Bukkit.API;

import br.net.fabiozumbi12.RedProtect.Bukkit.Region;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface ProtectionHook {

    Boolean canBuild(Player p, Region r);

    Boolean canPvp(Player attacker, Player victim, Region r);

    Boolean allowExplosion(Entity source, Region r);

    Boolean canInteract(Player p, Region r);

    boolean isLocked(Region r);
}
