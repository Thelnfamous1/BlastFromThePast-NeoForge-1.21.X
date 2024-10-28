package com.clonz.blastfromthepast.client.renderers;

import com.clonz.blastfromthepast.client.models.BurrelModel;
import com.clonz.blastfromthepast.entity.burrel.Burrel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.itskillerluc.duclib.client.model.Ducling;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class BurrelRenderer extends MobRenderer<Burrel, BurrelModel> {

    final ResourceLocation NORMAL = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_no_sap.png");
    final ResourceLocation NORMAL_SAP = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_sap.png");

    //TO Be discussed
    final ResourceLocation SCRAT = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_no_sap_scrat.png");
    final ResourceLocation NOT_SAP = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_not_sap.png");
    final ResourceLocation NO_SAP_SLEEP = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_no_sap_sleep.png");
    final ResourceLocation SAP_SLEEP = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_sap_sleep.png");
    final ResourceLocation EXOTIC = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_sap_exotic.png");
    final ResourceLocation EXOTIC_SLEEP = ResourceLocation.fromNamespaceAndPath("blastfromthepast", "textures/entity/burrel/brrrel_sap_exotic_sleep.png");

    public BurrelRenderer(EntityRendererProvider.Context context, BurrelModel model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    public BurrelRenderer(EntityRendererProvider.Context context) {
        super(context, new BurrelModel((Ducling) context.bakeLayer(BurrelModel.LOCATION)), 0.1F);
    }

    public Direction rotate(Direction attachment) {
        return attachment.getAxis() == Direction.Axis.Y ? Direction.UP : attachment;
    }

    @Override
    protected void setupRotations(Burrel entity, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        float prevProg = (entity.prevAttachChangeProgress + (entity.attachChangeProgress - entity.prevAttachChangeProgress) * partialTick);
        float yawMul = 0F;
        float trans = entity.isBaby() ? 0.2F : 0.4F;
        if(entity.prevAttachDir == entity.getAttachmentFacing() && entity.getAttachmentFacing().getAxis() == Direction.Axis.Y){
            yawMul = 1.0F;
        }
        poseStack.mulPose(Axis.YP.rotationDegrees ( (180.0F - yawMul * yBodyRot)));

        if(entity.getAttachmentFacing() == Direction.DOWN){
            poseStack.translate(0.0D, trans, 0.0D);
            if(entity.yo <= entity.getY()){
                poseStack.mulPose(Axis.XP.rotationDegrees(90 * prevProg));
            }else{
                poseStack.mulPose(Axis.XP.rotationDegrees(-90 * prevProg));
            }
            poseStack.translate(0.0D, -trans, 0.0D);
        }

    }

    @Override
    public ResourceLocation getTextureLocation(Burrel burrel) {
        if (burrel.getTypes() == 1) {
            return NORMAL_SAP;
        } else {
            return NORMAL;
        }
    }
}