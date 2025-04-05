package me.octo.client.config;

import gg.essential.universal.UMinecraft;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;

public class Config extends Vigilant {

    @Property(
            type = PropertyType.SWITCH,
            name = "Chat Features",
            description = "Does stuff with chat",
            category = "Chat",
            subcategory = "QOL"
    )
    public static boolean chatFeatures = false;
    public static boolean entityFinder = false;

    public static Config INSTANCE = new Config();

    public Config() {
        super(
                new File(UMinecraft.getMinecraft().mcDataDir, "config/clientbase.toml"),
                "ClientBase"
        );
        initialize();
    }
}