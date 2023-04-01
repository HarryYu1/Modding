package net.harry.yu.tutorialmod;
//matches group

import com.mojang.logging.LogUtils;
import net.harry.yu.tutorialmod.block.ModBlocks;
import net.harry.yu.tutorialmod.item.ModCreativeModeTab;
import net.harry.yu.tutorialmod.item.ModItems;
import net.harry.yu.tutorialmod.painting.ModPaintings;
import net.harry.yu.tutorialmod.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

//import now that 1.19.3 happened...
import java.awt.*;

import static net.harry.yu.tutorialmod.block.ModBlocks.*;
import static net.harry.yu.tutorialmod.item.ModItems.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    public static final String MOD_ID = "tutorialmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        //modEventBus.addListener(this::buildContents);

        //registers this and its subscriptions
        MinecraftForge.EVENT_BUS.register(this);
        //needs to be modeventbus for creative tabs
        modEventBus.register(this);
        modEventBus.register(new ModCreativeModeTab());

        //new way of adding to creative
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        //registration by event
        event.enqueueWork(()-> {
            ModVillagers.registerPOIs();
        });

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(GWAGGIUM);
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(GWASHIMOTO);
        if (event.getTab() == ModCreativeModeTab.MY_TAB) {

        }
    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //.setRenderLayer(BLUEBERRY_CROP.get(), RenderType.cutout());
            //^THIS IS NO LONGER USED, ITS NOW IN THE MODEL JSON FILE AS "render_type":
            }
    }
}
