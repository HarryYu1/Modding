package net.harry.yu.tutorialmod.datagen;

import net.harry.yu.tutorialmod.block.ModBlocks;
import net.harry.yu.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreBlasting(consumer, List.of(ModItems.GWASHIMOTO.get()), RecipeCategory.MISC, ModItems.GWAGGIUM.get(),
                //exp
                0.7f,
                200, "gwaggium");
        //look through RecipeProvider!

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.EIGHT_BALL.get(), RecipeCategory.MISC, ModBlocks.JUMPY_ITEM.get());
    }

    // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
    //         .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
    //         .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
    //                 .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
    //         .save(consumer);

    // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
    //         .define('B', ModItems.BLACK_OPAL.get())
    //         .pattern("BBB")
    //         .pattern("BBB")
    //         .pattern("BBB")
    //         .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
    //                 .of(ModItems.BLACK_OPAL.get()).build()))
    //         .save(consumer);

    //ABOVE ARE EXPLICIT DEFINITIONS
}
