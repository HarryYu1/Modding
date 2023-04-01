package net.harry.yu.tutorialmod.datagen;

import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 0);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 1);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 2);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 3);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 4);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 5);
        registerBerryBlock(ModBlocks.BLUEBERRY_CROP, 6);
    }

    private BlockModelBuilder registerBerryBlock(RegistryObject<Block> block, int age){
        return withExistingParent("tutorialmod:" + "block/blueberry_stage" + age, new ResourceLocation("minecraft:block/crop"))
                .renderType("cutout").texture("crop", new ResourceLocation(TutorialMod.MOD_ID, "block/blueberry_stage" + age));
    }
}
