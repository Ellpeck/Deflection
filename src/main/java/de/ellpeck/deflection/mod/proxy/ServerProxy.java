package de.ellpeck.deflection.mod.proxy;

import de.ellpeck.deflection.mod.reg.IColorProvidingBlock;
import de.ellpeck.deflection.mod.reg.IColorProvidingItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements IProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event){

    }

    @Override
    public void init(FMLInitializationEvent event){

    }

    @Override
    public void postInit(FMLPostInitializationEvent event){

    }

    @Override
    public void registerRenderer(ItemStack stack, ResourceLocation location, String variant){

    }

    @Override
    public void addColorProvidingItem(IColorProvidingItem item){

    }

    @Override
    public void addColorProvidingBlock(IColorProvidingBlock block){

    }

    @Override
    public void spawnMagicParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, int color, float scale, int maxAge, float gravity, boolean collision){

    }

    @Override
    public void scheduleTask(Runnable runnable){
        FMLCommonHandler.instance().getMinecraftServerInstance().addScheduledTask(runnable);
    }
}