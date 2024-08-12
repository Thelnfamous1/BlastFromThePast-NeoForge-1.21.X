package com.clonz.blastfromthepast.client.models;

import com.clonz.blastfromthepast.BlastFromThePast;
import com.clonz.blastfromthepast.entity.GlacerosEntity;
import io.github.itskillerluc.duclib.client.model.AnimatableDucModel;
import io.github.itskillerluc.duclib.client.model.Ducling;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.searchtree.SearchTree;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.function.Function;

public class GlacerosModel extends AnimatableDucModel<GlacerosEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(BlastFromThePast.MODID, "glaceros"), "main");

    public GlacerosModel(Ducling ducling) {
        super(ducling, RenderType::entityCutoutNoCull);
    }

    @Override
    protected Set<String> excludeAnimations() {
        return Set.of("animation.glaceros.flee", "animation.glaceros.walk");
    }

    @Override
    public void setupAnim(@NotNull GlacerosEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.animateWalk(pEntity.getAnimation().getAnimations().get("animation.glaceros.walk").animation(), pLimbSwing, pLimbSwingAmount, 1, 2);

        ((Ducling) getAnyDescendantWithName("neck").orElseThrow()).xRot = pHeadPitch * ((float)Math.PI / 180F);
        ((Ducling) getAnyDescendantWithName("neck").orElseThrow()).yRot = pNetHeadYaw * ((float)Math.PI / 180F);
    }
}