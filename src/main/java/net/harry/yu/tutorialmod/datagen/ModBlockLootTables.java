package net.harry.yu.tutorialmod.datagen;

import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.harry.yu.tutorialmod.item.ModItems;
import net.harry.yu.tutorialmod.villager.ModVillagers;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    //second is enabled features
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    //need to add everything apparently
    @Override
    protected void generate() {
        dropSelf(ModBlocks.JUMPY.get());
        dropSelf(ModBlocks.GWAGGIUM_BLOCK.get());

        add(ModBlocks.GWAGGIUM_LAMP.get(),
                (block) -> noDrop());

        //taken from loot, vanillaloot in packs
        LootItemCondition.Builder lootitemcondition$builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 6));
        add(ModBlocks.BLUEBERRY_CROP.get(),
                (block) -> createCropDrops(ModBlocks.BLUEBERRY_CROP.get(), ModItems.BLUEBERRY.get(),
                        ModItems.BLUEBERRY_SEEDS.get(), lootitemcondition$builder1));




        //ore
        add(ModBlocks.GWAGGIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.GWAGGIUM_ORE.get(), ModItems.GWASHIMOTO.get()));
        add(ModBlocks.DEEP_GWAGGIUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEP_GWAGGIUM_ORE.get(), ModItems.GWASHIMOTO.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        //gets all the registered entries, makes it into a stream, maps it into iterable form
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
