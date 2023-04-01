package net.harry.yu.tutorialmod.datagen;

import net.harry.yu.tutorialmod.TutorialMod;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.model.generators.BlockModelProvider;

import static net.harry.yu.tutorialmod.block.custom.BlueBerryCropBlock.AGE;

public class ModBlockStateProvider extends BlockStateProvider {

    private ExistingFileHelper exfilehelp;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
        this.exfilehelp = exFileHelper;
    }



    @Override
    protected void registerStatesAndModels() {
        BlockWithItem(ModBlocks.GWAGGIUM_BLOCK);
        BlockWithItem(ModBlocks.GWAGGIUM_ORE);
        BerryHelper(ModBlocks.BLUEBERRY_CROP);
    }

    //simple method that's provided that makes a simple block for us
    //cubeall provides the modelfile
    private void BlockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    //check this.getVariantBuilder in the future
    private void BerryHelper(RegistryObject<Block> blockRegistryObject) {

        //make blockstate
        this.getVariantBuilder(blockRegistryObject.get()) // Get variant builder
                .partialState() // Construct partial state
                .with(AGE, 0)
                    .modelForState() // Set models when AGE = 0
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage0"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()// Finalizes models when AGE = 0
                .partialState()
                .with(AGE, 1)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage1"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()
                .partialState()
                    .with(AGE, 2)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage2"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()
                .partialState()
                    .with(AGE, 3)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage3"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()
                .partialState()
                    .with(AGE, 4)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage4"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()
                .partialState()
                    .with(AGE, 5)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage5"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel()
                .partialState()
                    .with(AGE, 6)
                    .modelForState()
                    .modelFile(new ModelFile.ExistingModelFile(new ResourceLocation("tutorialmod:block/blueberry_stage6"), exfilehelp)) // Can show 'yModelFile1'
                    .addModel();
    }





    //generates blockstate
}
