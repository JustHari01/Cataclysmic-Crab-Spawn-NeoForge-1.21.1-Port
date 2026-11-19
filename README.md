# Cataclysmic Crab Spawn (UNOFFICIAL)

An unofficial NeoForge 1.21.1 port of [Cataclysmic Crab Spawn by ImMaxon](https://modrinth.com/mod/cataclysmic-crab-spawn).

Port source: [JustHari01/Cataclysm-Crab-Spawn-NeoForge-1.21.1-Port](https://github.com/JustHari01/Cataclysm-Crab-Spawn-NeoForge-1.21.1-Port).

## What it adds

The mod adds the craftable **Suspicious Looking Crab** item. Right-clicking it summons Cataclysm's Amethyst Crab, plays the beacon selection sound, and shows the same item-use animation and tooltip as the upstream mod. The item appears in Minecraft's Tools & Utilities creative tab.

The port keeps the original item ID, item texture, and recipe. Its recipe is:

```text
M B M
A S A
T T T
```

- `M`: Moss Block
- `B`: Big Dripleaf
- `A`: Amethyst Block
- `S`: Soul Sand
- `T`: Tuff

The original upstream uses a server-side summon command at a fixed local-coordinate offset. This port preserves that summon behavior and does not consume the item.

## Requirements

- Minecraft Java Edition 1.21.1
- NeoForge 21.1 or newer for Minecraft 1.21.1
- L_Ender's Cataclysm for Minecraft 1.21.1 NeoForge (`cataclysm` mod ID)

The Cataclysm mod is a required dependency and is not bundled with this port. No Cataclysm code, models, or textures are included.

## License and attribution

This project is MIT licensed. It retains the upstream `suscrab.png` item texture under the upstream project's MIT license. See [LICENSE](LICENSE), [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md), and [TEMPLATE_LICENSE.txt](TEMPLATE_LICENSE.txt).

This is an unofficial community port and is not affiliated with ImMaxon or L_Ender.

## Build

Use Java 21 and run `gradlew build` (Windows: `gradlew.bat build`).

The source has been compiled successfully against NeoForge 21.1.267. The game itself has not been launched for an in-game or multiplayer test, so this build result confirms compilation and packaging only.

AI tools assisted with analysis of the upstream package, implementation of the NeoForge port, and creation of the project's illustrative logo. The logo is not an in-game screenshot or Cataclysm model; the in-game item texture remains the upstream asset under its MIT license.
