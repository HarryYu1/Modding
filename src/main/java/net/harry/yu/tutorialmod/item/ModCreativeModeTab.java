package net.harry.yu.tutorialmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.harry.yu.tutorialmod.TutorialMod.MOD_ID;
import static net.harry.yu.tutorialmod.block.ModBlocks.*;
import static net.harry.yu.tutorialmod.item.ModItems.*;

public class ModCreativeModeTab{

    public void ModCreativeModeTab() {}
    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "example"),
                //name of tab to display
                builder -> builder.title(Component.translatable("item_group." + MOD_ID + ".example"))
                        //set icon
                        //.get fetches the item data I assume
                        .icon(()-> new ItemStack(GWAGGIUM.get()))
                        //add items to tab
                        .displayItems((enabled_flag, populator, has_permissions) -> {
                            populator.accept(GWAGGIUM.get());
                            populator.accept(GWASHIMOTO.get());
                            populator.accept(GWAGGIUM_BLOCK_ITEM.get());
                            populator.accept(GWAGGIUM_ORE_ITEM.get());
                            populator.accept(DEEP_GWAGGIUM_ORE_ITEM.get());
                            populator.accept(EIGHT_BALL.get());
                            populator.accept(JUMPY_ITEM.get());
                            populator.accept(GWAGGIUM_LAMP_ITEM.get());
                            populator.accept(BLUEBERRY_SEEDS.get());})
        );



    }

}
