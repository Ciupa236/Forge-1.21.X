package net.ciupa.tutorialmod.item;

import net.ciupa.tutorialmod.TutorialMod;
import net.ciupa.tutorialmod.item.custom.ChiselItem;
import net.ciupa.tutorialmod.item.custom.FuelItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CUP = ITEMS.register("cup",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BABY_OIL = ITEMS.register("baby_oil",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi.shift_down1"));
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi.shift_down2"));
                    } else {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.kohlrabi"));
                    }
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> DOG_TREAT = ITEMS.register("dog_treat",
            () -> new Item(new Item.Properties().food(ModFoodProperties.DOG_TREAT)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    if(Screen.hasShiftDown()) {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.dog_treat.shift_down"));
                    } else {
                        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.dog_treat"));
                    }

                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 1200));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
