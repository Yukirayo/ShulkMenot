package org.github.shulkmenot.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.github.shulkmenot.util.ShulkUtil;

import java.util.List;

public class ShulkMachine implements Listener {
    @EventHandler
    public void onShulk(CreatureSpawnEvent e) {
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG) {
            Entity entity = e.getEntity();
            Location location = e.getLocation();
            World world = location.getWorld();
            ShulkUtil s = new ShulkUtil();
            if (s.isHasBlock(location, 11, Material.DROPPER) && entity instanceof Shulker) {
                List<Entity> nearbyEntities = (List<Entity>) world.getNearbyEntities(location, 11, 11, 11);
                for (Entity nearbyEntity : nearbyEntities) {
                    if (nearbyEntity instanceof Shulker) {
                        Shulker shulker = (Shulker) entity;
                        Shulker shulker_aim = (Shulker) nearbyEntity;
                        shulker.setTarget(shulker_aim);
                    }
                }

            }
        }
    }
}