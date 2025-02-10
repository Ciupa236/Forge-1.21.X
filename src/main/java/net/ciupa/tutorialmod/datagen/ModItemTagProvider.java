package net.ciupa.tutorialmod.datagen;

import net.ciupa.tutorialmod.TutorialMod;
import net.ciupa.tutorialmod.item.ModItems;
import net.ciupa.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEM)
                .add(ModItems.ALEXANDRITE.get())
                .add(ModItems.RAW_ALEXANDRITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.ALEXANDRITE.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KAUPEN_SMITHING_TEMPLATE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.ALEXANDRITE_SWORD.get())
                .add(ModItems.GEM_REJUVENATOR.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.ALEXANDRITE_PICKAXE.get())
                .add(ModItems.ALEXANDRITE_HAMMER.get())
                .add(ModItems.GEM_REJUVENATOR.get());

        tag(ItemTags.AXES)
                .add(ModItems.ALEXANDRITE_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.ALEXANDRITE_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.ALEXANDRITE_HOE.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.KAUPEN_BOW.get());
    }
}
