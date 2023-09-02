package org.github.shulkmenot.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public final class ShulkUtil {
    public boolean isHasBlock(Location location, int radius, Material material){
        World world = location.getWorld();
        int locateX = location.getBlockX();
        int locateY = location.getBlockY();
        int locateZ = location.getBlockZ();

        for (int x = locateX - radius;x<= radius + locateX;x++){
            for (int y = locateY - radius;y<= radius + locateY;y++){
                for(int z = locateZ - radius;z<= radius + locateZ;z++){
                    Location check = new Location(world,x,y,z);
                    Block checkBlock = world.getBlockAt(check);
                    if (checkBlock.getType() == material){
                        Dropper dropper = (Dropper) checkBlock.getState();
                        Inventory inventory = dropper.getInventory();

                        for (ItemStack item: inventory.getContents()){
                            if (item!=null && item.getType() == Material.NETHER_STAR){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
