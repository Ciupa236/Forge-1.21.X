package net.ciupa.tutorialmod.item;

import net.ciupa.tutorialmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ALEXANDRITE = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL);

    public static final Tier REJUVENATOR = new ForgeTier(4096, 13, 5f, 25,
            ModTags.Blocks.NEEDS_REJUVENATOR_TOOL, () -> Ingredient.of(ModItems.RUBY.get()),
            ModTags.Blocks.INCORRECT_FOR_REJUVENATOR_TOOL);
}
