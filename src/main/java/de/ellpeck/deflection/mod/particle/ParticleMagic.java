package de.ellpeck.deflection.mod.particle;

import de.ellpeck.deflection.mod.util.ModUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleMagic extends Particle{

    public static final ResourceLocation RES_LOC = new ResourceLocation(ModUtil.MOD_ID, "particle/magic_round");

    private final float desiredScale;

    public ParticleMagic(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, int color, float scale, int maxAge, float gravity, boolean collision){
        super(world, posX, posY, posZ);
        this.desiredScale = scale*2;
        this.particleMaxAge = maxAge;
        this.canCollide = collision;
        this.particleGravity = gravity;

        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;

        this.setRBGColorF(((color >> 16) & 255)/255F, ((color >> 8) & 255)/255F, (color & 255)/255F);

        TextureMap map = Minecraft.getMinecraft().getTextureMapBlocks();
        this.setParticleTexture(map.getAtlasSprite(RES_LOC.toString()));

        this.particleAlpha = 0F;
        this.particleScale = 0F;
    }

    @Override
    public void onUpdate(){
        super.onUpdate();

        float lifeRatio = (float)this.particleAge/(float)this.particleMaxAge;
        if(lifeRatio > 0.5F){
            this.particleAlpha = 1F-lifeRatio;
            this.particleScale = this.desiredScale-(this.desiredScale*lifeRatio);
        }
        else{
            this.particleAlpha = lifeRatio;
            this.particleScale = this.desiredScale*lifeRatio;
        }
    }

    @Override
    public int getFXLayer(){
        return 1;
    }

    @Override
    public boolean isTransparent(){
        return true;
    }

    @Override
    public int getBrightnessForRender(float f){
        return 15 << 20 | 15 << 4;
    }
}