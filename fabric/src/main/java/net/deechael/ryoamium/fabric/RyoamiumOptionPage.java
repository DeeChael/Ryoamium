package net.deechael.ryoamium.fabric;

import com.google.common.collect.ImmutableList;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpact;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.CyclingControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import net.deechael.ryoamium.RyoamiumConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.embeddedt.embeddium.client.gui.options.OptionIdentifier;
import org.thinkingstudio.ryoamiclights.DynamicLightsMode;
import org.thinkingstudio.ryoamiclights.ExplosiveLightingMode;
import org.thinkingstudio.ryoamiclights.RyoamicLights;

import java.util.ArrayList;
import java.util.List;

public class RyoamiumOptionPage extends OptionPage {

    public static final OptionIdentifier<Void> ID = OptionIdentifier.create(new ResourceLocation(RyoamiumConstants.MOD_ID, "dynamic_lights"));

    public RyoamiumOptionPage() {
        super(ID, Component.translatable("ryoamium.options.dynamic_lights"), create());
    }

    private static ImmutableList<OptionGroup> create() {
        final List<OptionGroup> groups = new ArrayList<>();

        groups.add(
                OptionGroup.createBuilder()
                        .add(
                                OptionImpl.createBuilder(DynamicLightsMode.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "dynamic_lights_mode"))
                                        .setName(Component.translatable("ryoamiclights.option.mode"))
                                        .setTooltip(
                                                Component.translatable("ryoamiclights.tooltip.mode.1")
                                                        .append(Component.literal("\n"))
                                                        .append(Component.translatable("ryoamiclights.tooltip.mode.2", DynamicLightsMode.FASTEST.getTranslatedText(), DynamicLightsMode.FAST.getTranslatedText()))
                                                        .append(Component.literal("\n"))
                                                        .append(Component.translatable("ryoamiclights.tooltip.mode.3", DynamicLightsMode.FANCY.getTranslatedText()))
                                        )
                                        .setControl((opt) -> new CyclingControl<>(opt, DynamicLightsMode.class, new Component[]{
                                                DynamicLightsMode.OFF.getTranslatedText(),
                                                DynamicLightsMode.FASTEST.getTranslatedText(),
                                                DynamicLightsMode.FAST.getTranslatedText(),
                                                DynamicLightsMode.FANCY.getTranslatedText()
                                        }))
                                        .setBinding((options, value) -> RyoamicLights.get().config.setDynamicLightsMode(value),
                                                (options) -> RyoamicLights.get().config.getDynamicLightsMode())
                                        .setImpact(OptionImpact.MEDIUM)
                                        .build()
                        )
                        .build()
        );

        groups.add(
                OptionGroup.createBuilder()
                        .add(
                                OptionImpl.createBuilder(boolean.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_entities"))
                                        .setName(Component.translatable("ryoamiclights.option.light_sources.entities"))
                                        .setTooltip(Component.translatable("ryoamiclights.tooltip.entities"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> RyoamicLights.get().config.getEntitiesLightSource().set(value),
                                                (options) -> RyoamicLights.get().config.getEntitiesLightSource().get())
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(boolean.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_block_entities"))
                                        .setName(Component.translatable("ryoamiclights.option.light_sources.block_entities"))
                                        .setTooltip(Component.translatable("ryoamiclights.tooltip.block_entities"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> RyoamicLights.get().config.getBlockEntitiesLightSource().set(value),
                                                (options) -> RyoamicLights.get().config.getBlockEntitiesLightSource().get())
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(boolean.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_self"))
                                        .setName(Component.translatable("ryoamiclights.option.light_sources.self"))
                                        .setTooltip(Component.translatable("ryoamiclights.tooltip.self_light_source"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> RyoamicLights.get().config.getSelfLightSource().set(value),
                                                (options) -> RyoamicLights.get().config.getSelfLightSource().get())
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(boolean.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_water_sensitive_check"))
                                        .setName(Component.translatable("ryoamiclights.option.light_sources.water_sensitive_check"))
                                        .setTooltip(Component.translatable("ryoamiclights.tooltip.water_sensitive"))
                                        .setControl(TickBoxControl::new)
                                        .setBinding((options, value) -> RyoamicLights.get().config.getWaterSensitiveCheck().set(value),
                                                (options) -> RyoamicLights.get().config.getWaterSensitiveCheck().get())
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(ExplosiveLightingMode.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_creeper"))
                                        .setName(Component.translatable("entity.minecraft.creeper"))
                                        .setTooltip(
                                                Component.translatable("ryoamiclights.tooltip.creeper_lighting",
                                                        ExplosiveLightingMode.OFF.getTranslatedText(),
                                                        ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                                        ExplosiveLightingMode.FANCY.getTranslatedText()
                                                )
                                        )
                                        .setControl((opt) -> new CyclingControl<>(opt, ExplosiveLightingMode.class, new Component[]{
                                                ExplosiveLightingMode.OFF.getTranslatedText(),
                                                ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                                ExplosiveLightingMode.FANCY.getTranslatedText()
                                        }))
                                        .setBinding((options, value) -> RyoamicLights.get().config.setCreeperLightingMode(value),
                                                (options) -> RyoamicLights.get().config.getCreeperLightingMode())
                                        .build()
                        )
                        .add(
                                OptionImpl.createBuilder(ExplosiveLightingMode.class, RyoamiumOptions.STORAGE)
                                        .setId(new ResourceLocation(RyoamiumConstants.MOD_ID, "light_sources_tnt"))
                                        .setName(Component.translatable("entity.minecraft.tnt"))
                                        .setTooltip(
                                                Component.translatable("ryoamiclights.tooltip.tnt_lighting",
                                                        ExplosiveLightingMode.OFF.getTranslatedText(),
                                                        ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                                        ExplosiveLightingMode.FANCY.getTranslatedText()
                                                )
                                        )
                                        .setControl((opt) -> new CyclingControl<>(opt, ExplosiveLightingMode.class, new Component[]{
                                                ExplosiveLightingMode.OFF.getTranslatedText(),
                                                ExplosiveLightingMode.SIMPLE.getTranslatedText(),
                                                ExplosiveLightingMode.FANCY.getTranslatedText()
                                        }))
                                        .setBinding((options, value) -> RyoamicLights.get().config.setTntLightingMode(value),
                                                (options) -> RyoamicLights.get().config.getTntLightingMode())
                                        .build()
                        )
                        .build()
        );

        return ImmutableList.copyOf(groups);
    }

}
