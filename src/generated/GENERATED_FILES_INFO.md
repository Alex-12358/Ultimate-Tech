# Generated Files Information

## 📁 Structure

This directory (`src/generated/resources`) contains **generated** data files that are part of the mod:

```
src/generated/resources/
└── data/
    └── ultimate_tech/
        └── recipes/          # Auto-generated recipes (552+ files)
```

## 🔧 What's Here?

All recipe files in this folder are **generated** from `ModRecipeProvider.java` during data generation.

### Recipe Categories:

1. **Ore Processing**
   - `*_ingot_from_smelting_*_ore.json` - Smelting recipes
   - `*_ingot_from_blasting_*_ore.json` - Blasting recipes

2. **Storage Blocks**
   - `storage_*.json` - 9 ingots → 1 storage block
   - `*_from_storage.json` - 1 storage block → 9 ingots

3. **Raw Materials** (if applicable)
   - `raw_*.json` - Raw item recipes
   - `raw_*_block.json` - Raw block recipes

4. **Nuggets** (if applicable)
   - `*_from_nuggets.json` - 9 nuggets → 1 ingot
   - `*_nuggets.json` - 1 ingot → 9 nuggets

5. **Elevators**
   - `elevator_*.json` - Elevator crafting recipes (all 16 colors)

## 📝 Important Notes

- **DO NOT manually edit** files in this folder
- These files are generated from `ModRecipeProvider.java`
- All recipes are **automatically included** in the final JAR
- Changes should be made to `ModRecipeProvider.java`, then regenerate

## 🔄 How to Regenerate

Run the data generator:
```bash
./gradlew runData
```

This will update all recipe files based on the current `ModRecipeProvider.java` logic.

## 📦 Build Integration

The `build.gradle` automatically includes this folder in the resources:
```groovy
sourceSets.main.resources { srcDir 'src/generated/resources' }
```

This ensures all recipes are packaged in the final mod JAR.

