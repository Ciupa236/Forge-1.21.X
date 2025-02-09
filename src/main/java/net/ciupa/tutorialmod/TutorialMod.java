package net.ciupa.tutorialmod;

import com.mojang.logging.LogUtils;
import net.ciupa.tutorialmod.block.ModBlocks;
import net.ciupa.tutorialmod.component.ModDataComponentTypes;
import net.ciupa.tutorialmod.item.ModCreativeModeTabs;
import net.ciupa.tutorialmod.item.ModItems;
import net.ciupa.tutorialmod.sound.ModSounds;
import net.ciupa.tutorialmod.util.ModItemProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_ALEXANDRITE);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.KAUPEN_SMITHING_TEMPLATE);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.CUP);
            event.accept(ModItems.KOHLRABI);
            event.accept(ModItems.DOG_TREAT);
        }
        if(event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(ModItems.BABY_OIL);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.BABY_OIL);
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.ALEXANDRITE_PICKAXE);
            event.accept(ModItems.ALEXANDRITE_AXE);
            event.accept(ModItems.ALEXANDRITE_SHOVEL);
            event.accept(ModItems.ALEXANDRITE_HOE);
            event.accept(ModItems.ALEXANDRITE_HAMMER);
            event.accept(ModItems.GEM_REJUVENATOR);
            event.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
            event.accept(ModItems.IDI_NAHUI_MUSIC_DISC);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.ALEXANDRITE_STAIRS);
            event.accept(ModBlocks.ALEXANDRITE_SLAB);
            event.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
            event.accept(ModBlocks.ALEXANDRITE_BUTTON);
            event.accept(ModBlocks.ALEXANDRITE_FENCE);
            event.accept(ModBlocks.ALEXANDRITE_FENCE_GATE);
            event.accept(ModBlocks.ALEXANDRITE_WALL);
            event.accept(ModBlocks.ALEXANDRITE_DOOR);
            event.accept(ModBlocks.ALEXANDRITE_TRAPDOOR);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        }
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.MAGIC_BLOCK);
            event.accept(ModBlocks.ALEXANDRITE_LAMP);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ALEXANDRITE_SWORD);
            event.accept(ModItems.ALEXANDRITE_HELMET.get());
            event.accept(ModItems.ALEXANDRITE_CHESTPLATE.get());
            event.accept(ModItems.ALEXANDRITE_LEGGINGS.get());
            event.accept(ModItems.ALEXANDRITE_BOOTS.get());
            event.accept(ModItems.ALEXANDRITE_HORSE_ARMOR.get());
            event.accept(ModItems.KAUPEN_BOW);
            event.accept(ModItems.GEM_REJUVENATOR);

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
